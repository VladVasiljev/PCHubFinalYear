package com.example.vladislavsvasiljevs.pchub.Models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class cpuNameReading {
    public String Text;


    public cpuNameReading() {
    }

    public cpuNameReading(String text) {
        this.Text = text;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Text", Text);

        return result;
    }
}