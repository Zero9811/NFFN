package xin.zachary.nffn.dao;

import xin.zachary.nffn.entity.UserPreference;

import java.util.List;

public interface UserPreferenceDAO extends BaseDAO<UserPreference>{
    List queryTypeByUsername(String username);
}
