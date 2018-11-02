package gencana.com.android.githubsearch.view.ui.main

import android.view.KeyEvent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions
import com.schibsted.spain.barista.interaction.BaristaClickInteractions
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
    fun initialState(){
        BaristaVisibilityAssertions.apply {
            assertDisplayed(R.string.app_name)
            assertDisplayed(R.string.error_empty_initial)
            assertDisplayed(R.id.placeholder_view)
            assertNotDisplayed(R.id.swipe_refresh_main)
        }
    }

    @Test
    fun search() {
        BaristaClickInteractions.clickOn(R.id.action_search)

        onView(withId(R.id.search_src_text))
                .perform(typeText("github"), pressKey(KeyEvent.KEYCODE_ENTER))

        Thread.sleep(1000)
        scroll(15)
        scroll(5)
        scroll(18)
        scroll(4)
    }

    private fun scroll(position: Int){
        BaristaListInteractions.scrollListToPosition(R.id.recycler_main, position)
    }

}