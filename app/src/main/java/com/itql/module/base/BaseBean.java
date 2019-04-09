package com.itql.module.base;

import com.itql.module.util.JsonUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;

public class BaseBean implements Serializable {
	protected static final long serialVersionUID = 1L;

	public String[] getKeys() {
		return JsonUtil.beanToMap(this).keySet().toArray(new String[0]);
	}

	public Set<String> getKeySet() {
		return JsonUtil.beanToMap(this).keySet();
	}

	public List<String> getKeyList() {
		return new ArrayList<>(JsonUtil.beanToMap(this).keySet());
	}

	public Object[] getValues() {
		return JsonUtil.beanToMap(this).values().toArray();
	}

	public Set<Object> getValueSet() {
		return new LinkedHashSet<>(JsonUtil.beanToMap(this).values());
	}

	public List<Object> getValueList() {
		return new ArrayList<>(JsonUtil.beanToMap(this).values());
	}

	@NonNull
	public String toString() {
		return JsonUtil.beanToJson(this);
	}
}
