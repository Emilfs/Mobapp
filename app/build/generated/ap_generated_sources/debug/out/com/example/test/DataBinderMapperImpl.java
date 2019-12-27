package com.example.test;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.test.databinding.FragmentAddBindingImpl;
import com.example.test.databinding.FragmentHistoryBindingImpl;
import com.example.test.databinding.FrgmentAddBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTADD = 1;

  private static final int LAYOUT_FRAGMENTHISTORY = 2;

  private static final int LAYOUT_FRGMENTADD = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.test.R.layout.fragment_add, LAYOUT_FRAGMENTADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.test.R.layout.fragment_history, LAYOUT_FRAGMENTHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.test.R.layout.frgment_add, LAYOUT_FRGMENTADD);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTADD: {
          if ("layout/fragment_add_0".equals(tag)) {
            return new FragmentAddBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_add is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHISTORY: {
          if ("layout/fragment_history_0".equals(tag)) {
            return new FragmentHistoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_history is invalid. Received: " + tag);
        }
        case  LAYOUT_FRGMENTADD: {
          if ("layout-land/frgment_add_0".equals(tag)) {
            return new FrgmentAddBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for frgment_add is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/fragment_add_0", com.example.test.R.layout.fragment_add);
      sKeys.put("layout/fragment_history_0", com.example.test.R.layout.fragment_history);
      sKeys.put("layout-land/frgment_add_0", com.example.test.R.layout.frgment_add);
    }
  }
}
