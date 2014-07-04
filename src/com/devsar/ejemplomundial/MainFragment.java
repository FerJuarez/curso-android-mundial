package com.devsar.ejemplomundial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainFragment extends Fragment  implements OnRequestCompleted {
		private ListView list;
        public MainFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            list = (ListView) rootView.findViewById(R.id.list);
            list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> adapterView, View view,
						int pos, long id) {
					// TODO Auto-generated method stub
					MatchAdapter matchAdapter = (MatchAdapter) list.getAdapter();
					Log.e("Elemento seleccionado",((Match) matchAdapter.getItem(pos)).getAway_team().getCountry());
				}
			});
            ApiAsyncTask apiasync = new ApiAsyncTask(this);
            apiasync.execute();
            return rootView;
        }

		@Override
		public void onRequestCompleted(BaseHttpResult result) {
			// TODO Auto-generated method stub\\
			if(result.getSuccess()){
				if(result.getMatchs().size() > 0){
					MatchAdapter adapter = new MatchAdapter(getActivity(), result.getMatchs());
					   list.setAdapter(adapter);
			
				}else {
					
				}
				
				   
			}else {
				Toast.makeText(getActivity(),result.getMessage(), Toast.LENGTH_SHORT).show();
			}
				         
		}
    }
