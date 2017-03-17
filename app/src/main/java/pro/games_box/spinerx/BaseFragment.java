package pro.games_box.spinerx;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import pro.games_box.spinerx.BaseActivity;

public class BaseFragment extends Fragment {

    protected BaseActivity getParentCompat() {
        return (BaseActivity) getActivity();
    }

    protected void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void showProgress() {
        BaseActivity activity = getParentCompat();
        activity.showProgress();
    }

    public void removeProgress() {
        BaseActivity activity = getParentCompat();
        activity.removeProgress();
    }
}
