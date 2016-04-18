package me.xiaopan.assemblyadaptersample.itemfactory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.xiaopan.assemblyadapter.AssemblyGroupItem;
import me.xiaopan.assemblyadapter.AssemblyGroupItemFactory;
import me.xiaopan.assemblyadaptersample.R;
import me.xiaopan.assemblyadaptersample.bean.GameGroup;

public class GameGroupItemFactory extends AssemblyGroupItemFactory<GameGroupItemFactory.GameGroupItem>{

    @Override
    public boolean isTarget(Object itemObject) {
        return itemObject instanceof GameGroup;
    }

    @Override
    public GameGroupItem createAssemblyItem(ViewGroup parent) {
        return new GameGroupItem(inflateView(R.layout.list_group_game, parent), this);
    }

    public static class GameGroupItem extends AssemblyGroupItem<GameGroup, GameGroupItemFactory> {
        private TextView titleTextView;

        protected GameGroupItem(View convertView, GameGroupItemFactory itemFactory) {
            super(convertView, itemFactory);
        }

        @Override
        protected void onFindViews(View convertView) {
            titleTextView = (TextView) convertView.findViewById(R.id.text_gameListGroup_name);
        }

        @Override
        protected void onConfigViews(Context context) {

        }

        @Override
        protected void onSetData(int groupPosition, boolean isExpanded, GameGroup gameGroup) {
            if(isExpanded){
                titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_collapse, 0);
            }else{
                titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_expand, 0);
            }
            titleTextView.setText(gameGroup.title);
        }
    }
}
