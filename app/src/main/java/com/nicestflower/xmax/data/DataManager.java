package com.nicestflower.xmax.data;

import com.nicestflower.xmax.data.db.DbHelper;
import com.nicestflower.xmax.data.network.ApiHelper;
import com.nicestflower.xmax.data.prefs.PreferencesHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {
}
