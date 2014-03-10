package ru.homework.mine.criminalintent.app;

import android.support.v4.app.Fragment;

/**
 * Created by faradey on 3/10/14.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
