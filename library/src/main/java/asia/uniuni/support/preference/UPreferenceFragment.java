package asia.uniuni.support.preference;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Copyright 2016/06/25 UNIUNI. All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public abstract class UPreferenceFragment extends PreferenceFragmentCompat{

    public void setPreferenceClickListener(final String keyName , Preference.OnPreferenceClickListener listener) {
        setPreferenceClickListener(findPreference(keyName) ,listener);
    }
    public void setPreferenceClickListener(final Preference preference , Preference.OnPreferenceClickListener listener) {
        if (preference!=null){
            preference.setOnPreferenceClickListener(listener);
        }
    }

    public void setPreferenceChangeListener(final String keyName , Preference.OnPreferenceChangeListener listener) {
        setPreferenceChangeListener(findPreference(keyName) ,listener);
    }
    public void setPreferenceChangeListener(final Preference preference , Preference.OnPreferenceChangeListener listener) {
        if (preference!=null){
            preference.setOnPreferenceChangeListener(listener);
        }
    }
}
