package rinaldosilva.com.br.imdayapp;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import rinaldosilva.com.br.imdayapp.ui.incidente.IncidenteActivity;
import rinaldosilva.com.br.imdayapp.ui.incidente.IncidenteActivity_;

import static androidx.test.espresso.Espresso.onView;

@RunWith(AndroidJUnit4ClassRunner.class)
public class IncidenteUITest {

    @Rule
    public ActivityTestRule<IncidenteActivity_> mRule = new ActivityTestRule<>(IncidenteActivity_.class);


    @Test
    public void checkLogoBind() {
        onView(ViewMatchers.withId(R.id.btn_drawer)).perform(ViewActions.click()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

    public static Matcher<View> noDrawable() {
        return new DrawableMatcher(-1);
    }

}
