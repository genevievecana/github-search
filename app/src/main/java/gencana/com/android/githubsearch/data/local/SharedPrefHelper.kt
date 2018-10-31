package gencana.com.android.githubsearch.data.local

import android.content.SharedPreferences
import javax.inject.Inject


class SharedPrefHelper @Inject constructor(
        private val sharedPref: SharedPreferences){

    private fun saveString(key: String, value: String){
        sharedPref.edit().putString(key, value).commit()
    }

}