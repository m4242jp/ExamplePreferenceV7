package asia.uniuni.example.preference.v7;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.widget.Toast;

import asia.uniuni.support.preference.UPreferenceFragment;

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
public class SamplePreferenceFragment extends UPreferenceFragment
        implements Preference.OnPreferenceClickListener,Preference.OnPreferenceChangeListener{

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preference);
        setAllListener(getPreferenceScreen());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        setAllRemoveListener(getPreferenceScreen());
    }

    public void setAllListener(Preference preference){
        if(preference != null){
            if(preference instanceof PreferenceGroup){
                int c = ((PreferenceGroup)preference).getPreferenceCount();
                for(int i=0;i < c;i++)setAllListener(((PreferenceGroup)preference).getPreference(i));
            } else {
                if(preference.getKey()!=null) {
                    if (preference.getClass().equals(Preference.class)) {
                        setPreferenceClickListener(preference, this);
                    } else {
                        setPreferenceChangeListener(preference, this);
                    }
                }
            }
        }
    }
    public void setAllRemoveListener(Preference screen){
        if(screen != null){
            if(screen instanceof PreferenceGroup){
                int c = ((PreferenceGroup)screen).getPreferenceCount();
                for(int i=0; i < c;i++)setAllListener(((PreferenceGroup)screen).getPreference(i));
            } else {
                setPreferenceClickListener(screen,null);
                setPreferenceChangeListener(screen,null);
            }
        }
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        Toast.makeText(getActivity(), "key : " + preference.getKey() + "Clicked Preference", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        Toast.makeText(getActivity(), "key : " + preference.getKey() + " Changed " + o , Toast.LENGTH_SHORT).show();
        return true;
    }
}
