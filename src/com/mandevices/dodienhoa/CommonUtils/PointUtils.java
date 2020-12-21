package com.mandevices.dodienhoa.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointUtils {
    private static final Pattern axis = Pattern.compile("\\n(?<xAxis>-*[0-9]+)\\t(?<yAxis>-*[0-9]+)");
    private static final Pattern point = Pattern.compile("(\\n-*[0-9]+\\t-*[0-9]+)", Pattern.MULTILINE);

    public static List<HashMap<String, Integer>> getPoint(String input) {
        Matcher pointMatcher = point.matcher(input);
        List<HashMap<String, Integer>> result = new ArrayList<>();
        if (pointMatcher.find()) {
            for (int i = 0; i < pointMatcher.groupCount(); i = i + 1) {
                String p = pointMatcher.group(i + 1);
                result.add(getAxis(p));

            }

        }
        return result;
    }

    public static HashMap<String, Integer> getAxis(String point) {
        Matcher axisMatcher = axis.matcher(point);
        HashMap<String, Integer> result = new HashMap<>();
        if (axisMatcher.find()) {
            for (int j = 0; j < axisMatcher.groupCount(); j = j + 2) {
                String xValue = axisMatcher.group(1);
                String yValue = axisMatcher.group(2);
                result.put("x", Integer.parseInt(xValue));
                result.put("y", Integer.parseInt(yValue));

            }
        }
        return result;
    }
}
