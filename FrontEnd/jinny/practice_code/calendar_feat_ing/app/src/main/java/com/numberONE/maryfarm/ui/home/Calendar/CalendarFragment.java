package com.numberONE.maryfarm.ui.home.Calendar;

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
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;
import com.numberONE.maryfarm.databinding.FragmentCalendarBinding;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnRangeSelectedListener;
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter;
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class CalendarFragment extends Fragment {
    FragmentCalendarBinding binding;

    private final String TAG = this.getClass().getSimpleName();
    // 달력
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("EEE, d MMM yyyy");
    @BindView(R.id.calendarView)
        MaterialCalendarView widget;
//    @BindView(R.id.check_plant_appearance)
//        CheckBox plant_check;
    // 리사이클러뷰
    RecyclerView recyclerView_plants;
    RecyclerView.LayoutManager layoutManager_plants;
    RecyclerView.Adapter adapter_plants;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalendarBinding.inflate(inflater, container, false);

        // 식물 목록 리사이클러뷰 생성
        recyclerView_plants = binding.calendarPlantsType;
        layoutManager_plants = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerView_plants.setLayoutManager(layoutManager_plants);

        // 서버에서 식물 받아와서 파라미터 전해주기
        String[] plantname = {"감자", "고구마", "당근"};
        String[] dday = {"(D+10)", "(D+5)", "(D+1)"};
        adapter_plants = new CalendarPlantsAdapter(plantname, dday);
        recyclerView_plants.setAdapter(adapter_plants);

        ViewGroup view = binding.getRoot();

        ButterKnife.bind(this, view);

        int checked_plant = -1;

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
                String startDay = dates.get(0).getDate().toString();
                String endDay = dates.get(dates.size() - 1).getDate().toString();
                Log.e(TAG, "시작일 : " + startDay + ", 종료일 : " + endDay);
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

