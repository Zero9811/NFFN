package xin.zachary.nffn.service;

import xin.zachary.nffn.entity.UserPreference;

import java.io.File;
import java.util.List;

public interface UserPreferenceService extends BaseService<UserPreference> {
    boolean cluster();
    boolean changeToWeka();
    boolean updateType(double[] type);
    List queryTypeByUsername(String username);
}
