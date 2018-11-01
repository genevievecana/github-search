package gencana.com.android.githubsearch.view.ui.main

import android.view.KeyEvent
import androidx.test.espresso.action.ViewActions.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions
import com.schibsted.spain.barista.interaction.BaristaClickInteractions
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions
import com.schibsted.spain.barista.interaction.BaristaListInteractions
import gencana.com.android.githubsearch.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    private lateinit var mActivity: MainActivity

    @Before
    fun setActivity() {
        mActivity = mActivityRule.activity
    }

    @Test
    fun search() {
        BaristaVisibilityAssertions.assertDisplayed(R.string.app_name)
        BaristaClickInteractions.clickOn(R.id.action_search)
        BaristaEditTextInteractions.writeTo(R.id.search_src_text, "gen")
        pressKey(KeyEvent.KEYCODE_ENTER)
        BaristaListInteractions.scrollListToPosition(R.id.recycler_main, 15)
        BaristaListInteractions.scrollListToPosition(R.id.recycler_main, 5)
        BaristaListInteractions.scrollListToPosition(R.id.recycler_main, 18)
        BaristaListInteractions.scrollListToPosition(R.id.recycler_main, 4)
        BaristaListInteractions.clickListItem(R.id.recycler_main, 4)
    }

}