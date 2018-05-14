package test.com.helper;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import test.com.helper.base.BaseFragment;
import test.com.helper.pojo.Album;

public class ImageFragment extends BaseFragment implements ImageView {
    @BindView(R.id.recylerView)
    RecyclerView recyclerView;
    private ImageAdapter mAdapter;
    @Inject
    ImagePresenter imagePresenter;



    @Override
    protected void setUp(View view) {
        ((App) getBaseActivity().getApplicationContext()).getNetComponent().inject(this);
        imagePresenter.onAttach(this);
        imagePresenter.loadData();
        mAdapter = new ImageAdapter(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    protected int resourcID() {
        return R.layout.image_fragment;
    }

    @Override
    public void onClickListner() {

    }

    @Override
    public void loadData(List<Album> users) {
        mAdapter.setItem(users);

    }

}
