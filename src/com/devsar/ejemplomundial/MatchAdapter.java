package com.devsar.ejemplomundial;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MatchAdapter extends BaseAdapter {

	private final LayoutInflater mInflater;
	private final List<Match> list;

	private static class ViewHolder {
		public TextView textLocation;
		public TextView textDate;
		public TextView textTeamHome;
		public TextView textTeamHomeGoals;
		public TextView textTeamAway;
		public TextView textTeamAwayGoals;
	}


	public MatchAdapter(Context context, List<Match> matchs) {
		this.mInflater = LayoutInflater.from(context);
		this.list = matchs;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.match_row, null);

			viewHolder = new ViewHolder();
			viewHolder.textTeamHome = (TextView) convertView
					.findViewById(R.id.textTeamHome);

			viewHolder.textTeamAway = (TextView) convertView
					.findViewById(R.id.textTeamAway);

			viewHolder.textTeamHomeGoals = (TextView) convertView
					.findViewById(R.id.textGoalsHome);

			viewHolder.textTeamAwayGoals = (TextView) convertView
					.findViewById(R.id.textGoalsAway);

			viewHolder.textLocation = (TextView) convertView
					.findViewById(R.id.textLocation);
			
			viewHolder.textDate = (TextView) convertView
					.findViewById(R.id.textDate);
			
			
			convertView.setTag(viewHolder);
		}

		viewHolder = initView((ViewHolder) convertView.getTag(), list.get(position));
		return convertView;
	}

	public ViewHolder initView( ViewHolder viewHolder, Match match) {
		// populate view with match data
		viewHolder.textLocation.setText(match.getLocation());
		viewHolder.textDate.setText(match.getDatetime());
		viewHolder.textTeamAway.setText(match.getAway_team().getCountry());
		//viewHolder.textTeamAwayGoals.setText(match.getAway_team().getGoals());
		return viewHolder;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return list.get(position).getMatch_number();
	}

}