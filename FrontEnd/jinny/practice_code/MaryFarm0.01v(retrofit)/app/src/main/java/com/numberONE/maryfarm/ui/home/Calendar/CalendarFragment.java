package com.numberONE.maryfarm.ui.home.Calendar;

import static android.content.ContentValues.TAG;
import static com.prolificinteractive.materialcalendarview.MaterialCalendarView.SELECTION_MODE_RANGE;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;
import com.numberONE.maryfarm.Retrofit.Calendar.ItemModel;
import com.numberONE.maryfarm.Retrofit.Calendar.RetrofitFactory;
import com.numberONE.maryfarm.Retrofit.Calendar.RetrofitService;
import com.numberONE.maryfarm.databinding.FragmentCalendarBinding;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnRangeSelectedListener;
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter;
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarFragment extends Fragment {
    private FragmentCalendarBinding binding;

    private final String TAG = this.getClass().getSimpleName();
    // 달력
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("EEE, d MMM yyyy");
    @BindView(R.id.calendarView)
        MaterialCalendarView widget;
//    @BindView(R.id.check_plant_appearance)
//        CheckBox plant_check;
    // 리사이클러뷰
    RecyclerView recyclerView_plants, recyclerView_memo;
    RecyclerView.LayoutManager layoutManager_plants, layoutManager_memo;
    RecyclerView.Adapter adapter_plants, adapter_memo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        ViewGroup view = binding.getRoot();
        ButterKnife.bind(this, view);
        int checked_plant = -1;
        // 서버에서 식물 받아와서 파라미터 전해주기
        List<String> plantnameList = new ArrayList<>();
        final String[][] plantname = new String[1][1];
        String[] dday = {"(D+10)", "(D+5)", "(D+1)"};

    //레트로핏
        RetrofitService networkService = RetrofitFactory.create();
        networkService.getList()
            .enqueue(new Callback<List<ItemModel>>() {
                @Override
                public void onResponse(Call<List<ItemModel>> call, Response<List<ItemModel>> response){
                    if(response.isSuccessful()){
                        Log.i(TAG, "onResponse: 서버와 연결");
//                        Myadapter adapter = new Myadapter(response.body());
//                        binding.mainList.setAdapter(adapter);
                        //binding.alarmText.setText(response.body().);
                        List<ItemModel> body = response.body();
                        for(ItemModel m : body) {
                            plantnameList.add(m.getPlant());
                        }
                        plantname[0] = plantnameList.stream().toArray(String[]::new);
                    }
                }
                @Override
                public void onFailure(Call<List<ItemModel>> call, Throwable t){
                    Log.e(TAG, "onFailure: 서버 연결 실패");
                    Log.e(TAG, "onFailure:", t);
                }
            });
    //레트로핏 끝

    // 식물 목록 리사이클러뷰 생성
        recyclerView_plants = binding.calendarPlantsType;
        layoutManager_plants = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerView_plants.setLayoutManager(layoutManager_plants);

        // 어댑터 연결
        adapter_plants = new CalendarPlantsAdapter(plantname[0], dday);
        recyclerView_plants.setAdapter(adapter_plants);

//        // 리스너 객체 전달 메서드와 변수 추가.
//        adapter_plants.setOnPlantCheckListener(new CalendarPlantsAdapter.onPlantCheckListener() {
//            @Override
//            public void onPlantCheckClick(View v, int position) {
//                // TODO : 아이템 클릭 이벤트를 MainActivity에서 처리.
//                Toast.makeText(getActivity(), position, Toast.LENGTH_SHORT).show();
//            }
//        }) ;
    //일자 목록 리싸이클러 뷰 생성
//        recyclerView_memo = binding.calendarPickDate;
//        layoutManager_memo = new LinearLayoutManager(getActivity());
//        recyclerView_memo.setLayoutManager(layoutManager_memo);
//
//        // 받아온 서버 식물 파라미터 농작물 리스트 리싸이클러뷰랑 공유
//
//        // 어댑터 연결
//        adapter_memo = new CalendarPickPlantAdapter(plantname, dday);
//        recyclerView_memo.setAdapter(adapter_memo);

    // 달력 커스텀
        // 첫 시작 요일이 월요일이 되도록 설정
        binding.calendarView.state()
                .edit()
                .setFirstDayOfWeek(DayOfWeek.of(Calendar.SUNDAY))
                .commit();
        // 월, 요일을 한글로 보이게 설정 (MonthArrayTitleFormatter의 작동을 확인하려면 밑의 setTitleFormatter()를 지운다)
        binding.calendarView.setTitleFormatter(new MonthArrayTitleFormatter(getResources().getTextArray(R.array.custom_months)));
        binding.calendarView.setWeekDayFormatter(new ArrayWeekDayFormatter(getResources().getTextArray(R.array.custom_weekdays)));

        // 좌우 화살표 사이 연, 월의 폰트 스타일 설정
        binding.calendarView.setHeaderTextAppearance(R.style.CalendarWidgetHeader);

        // 요일 선택 시 내가 정의한 드로어블이 적용되도록 함
        binding.calendarView.setOnRangeSelectedListener(new OnRangeSelectedListener() {
            @Override
            public void onRangeSelected(@NonNull MaterialCalendarView widget, @NonNull List<CalendarDay> dates) {
                // 아래 로그를 통해 시작일, 종료일이 어떻게 찍히는지 확인하고 본인이 필요한 방식에 따라 바꿔 사용한다
                // UTC 시간을 구하려는 경우 이 라이브러리에서 제공하지 않으니 별도의 로직을 짜서 만들어내 써야 한다
//                String startDay = dates.get(0).getDate().toString();
//                String endDay = dates.get(dates.size() - 1).getDate().toString();
                String startDay = "2023-02-01";
                String endDay = "2023-02-28";
                Log.i(TAG, "시작일 : " + startDay + ", 종료일 : " + endDay);
            }
        });
    // 달력 커스텀 끝
        // 일자 클릭 시
        binding.calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(
                    @NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Log.i(TAG, "onDateSelected: 눌림");
//                binding.textView.setText(selected ? FORMATTER.format(date.getDate()) : "No Selection");
//                binding.textView.setText("감자 \n (D+10)");
//                binding.plantPick.setVisibility(View.VISIBLE);
//                binding.calendarPlantsType.setVisibility(View.GONE);
                recyclerView_memo = binding.calendarPickDate;
                layoutManager_memo = new LinearLayoutManager(getActivity());
                recyclerView_memo.setLayoutManager(layoutManager_memo);

                // 받아온 서버 식물 파라미터 농작물 리스트 리싸이클러뷰랑 공유

                // 어댑터 연결
                adapter_memo = new CalendarPickPlantAdapter(plantname[0], dday);
                recyclerView_memo.setAdapter(adapter_memo);
                binding.calendarPickDate.setVisibility(View.VISIBLE);
            }
        });

        // 일자 선택 시 내가 정의한 드로어블이 적용되도록 한다
        binding.calendarView.addDecorators(new DayDecorator(getActivity()));
        // 좌우 화살표 가운데의 연/월이 보이는 방식 커스텀
        binding.calendarView.setTitleFormatter(new TitleFormatter() {
            @Override
            public CharSequence format(CalendarDay day) {
                // CalendarDay라는 클래스는 LocalDate 클래스를 기반으로 만들어진 클래스다
                // 때문에 MaterialCalendarView에서 연/월 보여주기를 커스텀하려면 CalendarDay 객체의 getDate()로 연/월을 구한 다음 LocalDate 객체에 넣어서
                // LocalDate로 변환하는 처리가 필요하다
                LocalDate inputText = day.getDate();
                String[] calendarHeaderElements = inputText.toString().split("-");
                StringBuilder calendarHeaderBuilder = new StringBuilder();
                calendarHeaderBuilder.append(calendarHeaderElements[0])
                        .append(" ")
                        .append(calendarHeaderElements[1]);
                return calendarHeaderBuilder.toString();
            }
        });
//        plant_check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onCheckboxClicked(View v) {
//                onCheckboxClicked(View v);
//            }
//        });
//        class PlantCheckboxEventHandler implements CompoundButton.OnCheckedChangeListener{
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//            }
//        }
//        recyclerView_plants.findViewById(checkPlantAppearance).check_plant_appearance.setOnCheckedChangeListener(new PlantCheckboxEventHandler());
        return view;
    }

    // 날짜 찾기 버튼 클릭 시
    @OnClick(R.id.pick_date)
    void onSelectedClicked() {
        showDatePickerDialog(getActivity(), widget.getSelectedDate(),
                (view, year, monthOfYear, dayOfMonth) ->
                        widget.setSelectedDate(CalendarDay.from(year, monthOfYear + 1, dayOfMonth))
        );
    }
    // 날짜 설정 모달 및 선택 이동
    public static void showDatePickerDialog(
            Context context, CalendarDay day,
            DatePickerDialog.OnDateSetListener callback) {
        if (day == null) {
            day = CalendarDay.today();
        }
        DatePickerDialog dialog = new DatePickerDialog(
                context, 0, callback, day.getYear(), day.getMonth() - 1, day.getDay()
        );
        dialog.show();
    }


//    public void onCheckboxClicked(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
////         레인지로 바꾸고 widget.setSelectionMode(1, 3);
//        widget.setSelectionMode(SELECTION_MODE_RANGE);
//        switch(view.getId()) {
//            case R.id.check_plant_appearance:
//                if (checked)
////                    // 날짜 선택하고
//
////                    // 선택한 날 색 바꾸기
//            else
////                // 날짜 바꾸고
////                // 선택한 날 색 바꾸고
//                break;
//        }
//    }

    // 아래로 데코레이터
    private static class DayDecorator implements DayViewDecorator {
        private final Drawable drawable;
        public DayDecorator(Context context) {
            drawable = ContextCompat.getDrawable(context, R.drawable.calendar_selector);
        }

        // true를 리턴 시 모든 요일에 내가 설정한 드로어블이 적용된다
        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return true;
        }

        // 일자 선택 시 내가 정의한 드로어블이 적용되도록 한다
        @Override
        public void decorate(DayViewFacade view) {
            view.setSelectionDrawable(drawable);
//            view.addSpan(new StyleSpan(Typeface.BOLD));   // 달력 안의 모든 숫자들이 볼드 처리됨
        }
    }
}

