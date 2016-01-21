/*
 * Copyright (c) 2015 NECTEC
 *   National Electronics and Computer Technology Center, Thailand
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package th.or.nectec.android.widget.thai.utils;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private static final String ENCODING_UTF_8 = "UTF-8";

    public static <T> List<T> list(Context context, String jsonFileName, Type typeOfT) {
        List<T> list = new ArrayList<>();
        Gson gson = new Gson();
        try {
            InputStream inputStream = context.getAssets().open(jsonFileName);
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, ENCODING_UTF_8));
            reader.beginArray();
            while (reader.hasNext()) {
                T item = gson.fromJson(reader, typeOfT);
                list.add(item);
            }
            reader.endArray();
            reader.close();
        } catch (IOException e) {
            throw new JsonParserException(e);
        }
        return list;
    }

    public static class JsonParserException extends RuntimeException {

        public JsonParserException(IOException ioException) {
            super(ioException);
        }
    }
}