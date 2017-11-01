/*
 * Copyright (c) 2016 NECTEC
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
 *
 */

package nectec.thai.widget.identity;

import android.content.Context;
import android.util.AttributeSet;

import nectec.thai.identity.CitizenId;

public class CitizenIdEditText extends IdentityEditText<CitizenId> {

    public static final String DEFAULT_ERROR_MESSAGE = "รหัสประชาชนไม่ถูกต้อง";

    public CitizenIdEditText(Context context) {
        this(context, null);
    }

    public CitizenIdEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public CitizenIdEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(new CitizenIdHandler(this), DEFAULT_ERROR_MESSAGE);
    }
}
