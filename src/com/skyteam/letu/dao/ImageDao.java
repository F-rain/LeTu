package com.skyteam.letu.dao;

import java.util.List;

public interface ImageDao {
    public boolean saveImagePath(String Type, String ID, String ImagePath);
    public List<String> getImagePath(String Type, String ID);
}
