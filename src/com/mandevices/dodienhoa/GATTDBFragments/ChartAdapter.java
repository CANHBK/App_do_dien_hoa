package com.mandevices.dodienhoa.GATTDBFragments;

import com.robinhood.spark.SparkAdapter;

import java.util.HashMap;
import java.util.List;

public class ChartAdapter extends SparkAdapter {
    private List<HashMap<String, Integer>> data;

    public ChartAdapter(List<HashMap<String, Integer>> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int index) {
        return data.get(index);
    }

    @Override
    public float getY(int index) {
        return data.get(index).get("y");
    }

    @Override
    public float getX(int index) {
        return data.get(index).get("x");
    }
}
