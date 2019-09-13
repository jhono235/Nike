package com.example.nike.viewmodel;

import android.text.Editable;
import android.util.Log;
import android.view.View;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.MutableLiveData;

import com.example.nike.model.datasource.remote.retrofit.RetrofitHelper;
import com.example.nike.model.results.Definition;
import com.example.nike.model.results.DefinitionList;
import com.example.nike.view.adapters.RecyclerViewAdapter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ViewModel extends androidx.lifecycle.ViewModel implements Observable {
    PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    public MutableLiveData<String> words = new MutableLiveData<>();
    public MutableLiveData<List<Definition>> definitionListMutableLiveData = new MutableLiveData<>();

    @Bindable
    public RecyclerViewAdapter recyclerViewAdapter;

    public void afterWordTextChanged(Editable editable){
        words.postValue(editable.toString());
    }



    public void onGetResults(View view){
        final String wordDesired = words.getValue();

        RetrofitHelper helper = new RetrofitHelper();
        helper.getResultService()
                .getDefinitions(wordDesired)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DefinitionList>() {
                    private DefinitionList definitions;
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DefinitionList definition) {
                        this.definitions = definition;

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG_PRESENTER_DETAIL", "ERROR IN API CALL --> ", e);

                    }

                    @Override
                    public void onComplete() {
                        definitionListMutableLiveData.postValue(definitions.getList());

                    }
                });

    }

    public void setAdapter(List<Definition> definition){
        recyclerViewAdapter = new RecyclerViewAdapter(definition);
        notifyAllPropertiesChanged();
    }




    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
propertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
propertyChangeRegistry.remove(callback);
    }

    public void notifyAllPropertiesChanged(){
        propertyChangeRegistry.notifyChange(this, 0);
    }
}
