/*
 * Copyright (C) 2015 AppTik Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apptik.multiview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.djodjo.json.JsonArray;

import io.apptik.multiview.R;


/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class BasicRecyclerAdapter extends RecyclerView.Adapter<BasicRecyclerAdapter.ViewHolder> {
    private static final String TAG = "RecyclerAdapter";
    public final JsonArray jarr;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txt1;
        public final TextView txt2;
        public final TextView txt3;
        public final TextView txt4;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            txt1 = (TextView) v.findViewById(R.id.txt1);
            txt2 = (TextView) v.findViewById(R.id.txt2);
            txt3 = (TextView) v.findViewById(R.id.txt3);
            txt4 = (TextView) v.findViewById(R.id.txt4);
        }

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     */
    public BasicRecyclerAdapter(JsonArray jsonArray) {
        jarr = jsonArray;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_card, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        viewHolder.txt1.setText(jarr.getJsonObject(position).getString("title"));
        viewHolder.txt3.setText(jarr.getJsonObject(position).getString("info") + "/" +
                jarr.getJsonObject(position).getString("info2"));
        viewHolder.txt4.setText(jarr.getJsonObject(position).getString("info3"));
        viewHolder.txt2.setText("pos: " + position + ", id: " + jarr.getJsonObject(position).getInt("id"));


    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return jarr.size();
    }

//    @Override
//    public long getItemId(int position) {
//        return jarr.getJsonObject(position).getLong("id");
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return position % 2;
//    }
}
