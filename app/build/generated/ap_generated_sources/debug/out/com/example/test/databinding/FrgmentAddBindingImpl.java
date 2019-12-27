package com.example.test.databinding;
import com.example.test.R;
import com.example.test.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FrgmentAddBindingImpl extends FrgmentAddBinding implements com.example.test.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textInputLayout2, 4);
        sViewsWithIds.put(R.id.middleLine, 5);
        sViewsWithIds.put(R.id.radioGroup, 6);
        sViewsWithIds.put(R.id.isExpenses, 7);
        sViewsWithIds.put(R.id.howMuchText, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener amountInputandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.amount.getValue()
            //         is viewModel.amount.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(amountInput);
            // localize variables for thread safety
            // viewModel.amount != null
            boolean viewModelAmountJavaLangObjectNull = false;
            // viewModel.amount.getValue()
            java.lang.String viewModelAmountGetValue = null;
            // viewModel.amount
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelAmount = null;
            // viewModel
            com.example.test.ui.main.add.AddViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelAmount = viewModel.getAmount();

                viewModelAmountJavaLangObjectNull = (viewModelAmount) != (null);
                if (viewModelAmountJavaLangObjectNull) {




                    viewModelAmount.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener isIncomeandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.isIncome.getValue()
            //         is viewModel.isIncome.setValue((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = isIncome.isChecked();
            // localize variables for thread safety
            // viewModel.isIncome.getValue()
            java.lang.Boolean viewModelIsIncomeGetValue = null;
            // viewModel.isIncome
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsIncome = null;
            // viewModel.isIncome != null
            boolean viewModelIsIncomeJavaLangObjectNull = false;
            // viewModel
            com.example.test.ui.main.add.AddViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelIsIncome = viewModel.getIsIncome();

                viewModelIsIncomeJavaLangObjectNull = (viewModelIsIncome) != (null);
                if (viewModelIsIncomeJavaLangObjectNull) {




                    viewModelIsIncome.setValue(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };

    public FrgmentAddBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FrgmentAddBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[3]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (android.widget.TextView) bindings[8]
            , (android.widget.RadioButton) bindings[7]
            , (android.widget.RadioButton) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (android.widget.RadioGroup) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[4]
            );
        this.addPageButton.setTag(null);
        this.amountInput.setTag(null);
        this.isIncome.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.test.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.example.test.ui.main.add.AddViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.test.ui.main.add.AddViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelIsIncome((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeViewModelAmount((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsIncome(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsIncome, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelAmount(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelAmount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.Boolean viewModelIsIncomeGetValue = null;
        java.lang.String viewModelAmountGetValue = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsIncomeGetValue = false;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsIncome = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelAmount = null;
        com.example.test.ui.main.add.AddViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isIncome
                        viewModelIsIncome = viewModel.getIsIncome();
                    }
                    updateLiveDataRegistration(0, viewModelIsIncome);


                    if (viewModelIsIncome != null) {
                        // read viewModel.isIncome.getValue()
                        viewModelIsIncomeGetValue = viewModelIsIncome.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isIncome.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelIsIncomeGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsIncomeGetValue);
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.amount
                        viewModelAmount = viewModel.getAmount();
                    }
                    updateLiveDataRegistration(1, viewModelAmount);


                    if (viewModelAmount != null) {
                        // read viewModel.amount.getValue()
                        viewModelAmountGetValue = viewModelAmount.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.addPageButton.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.amountInput, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, amountInputandroidTextAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.isIncome, (android.widget.CompoundButton.OnCheckedChangeListener)null, isIncomeandroidCheckedAttrChanged);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.amountInput, viewModelAmountGetValue);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.isIncome, androidxDatabindingViewDataBindingSafeUnboxViewModelIsIncomeGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.example.test.ui.main.add.AddViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onSubmitClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isIncome
        flag 1 (0x2L): viewModel.amount
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}