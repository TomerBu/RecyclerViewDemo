package com.valdio.valdioveliu.recyclerview;

import android.support.v7.widget.RecyclerView;

public class OnVerticalScrollListener
        extends RecyclerView.OnScrollListener {

    private final RecyclerViewPositionHelper recyclerViewPositionHelper;
    private boolean pullToRefresh = false;
    private boolean infiniteScroll = false;

    public OnVerticalScrollListener(RecyclerView recyclerView) {
        recyclerViewPositionHelper = new RecyclerViewPositionHelper(recyclerView);
    }

    @Override
    public final void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        int totalItems = recyclerView.getLayoutManager().getItemCount();

        //to top
        if (recyclerViewPositionHelper.findFirstCompletelyVisibleItemPosition() == 0) {
            if (!pullToRefresh) {
                pullToRefresh = true;
                onPullToRefresh();
                pullToRefresh = false;
            }
        } else if (recyclerViewPositionHelper.findLastCompletelyVisibleItemPosition() == totalItems - 1) {
            if (!infiniteScroll) {
                infiniteScroll = true;
                onInfiniteScroll();
                infiniteScroll = false;
            }
        } else if (dy < 0) {
            onScrolledUp();
        } else if (dy > 0) {
            onScrolledDown();
        }
    }

    public void onPullToRefresh() {
        //System.out.println("Scrolled to top");
    }

    public void onInfiniteScroll() {
        //System.out.println("Scrolled to Bottom");
    }

    public void onScrolledUp() {
        //System.out.println("Scrolled Up");
    }

    public void onScrolledDown() {
        //System.out.println("Scrolled Down");
    }
}