package rinaldosilva.com.br.imdayapp;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import rinaldosilva.com.br.imdayapp.ui.splash.SplashActivity;
import rinaldosilva.com.br.imdayapp.ui.splash.SplashActivity_;

import static androidx.test.espresso.Espresso.onView;
@RunWith(AndroidJUnit4ClassRunner.class)
public class SplashUITest {

    @Rule
    public ActivityTestRule<SplashActivity_> mRule = new ActivityTestRule<>(SplashActivity_.class);


    @Test
    public void checkLogoBind() {
        //Testa o preenchimento do logo no splash.
        onView(ViewMatchers.withId(R.id.iv_logo)).check(ViewAssertions.matches(noDrawable()));

    }

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

    public static Matcher<View> noDrawable() {
        return new DrawableMatcher(0);
    }

}
