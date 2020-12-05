package org.example;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CovidResponse {

    @JsonProperty("date")
    private String date;
    @JsonProperty("day")
    private String day;
    @JsonProperty("people_tested_total")
    private String peopleTestedTotal;
    @JsonProperty("people_positive_total")
    private String peoplePositiveTotal;
    @JsonProperty("people_not_positive_total")
    private String peopleNotPositiveTotal;
    @JsonProperty("people_tested_age_0_17")
    private String peopleTestedAge017;
    @JsonProperty("people_tested_age_18_29")
    private String peopleTestedAge1829;
    @JsonProperty("people_tested_age_30_39")
    private String peopleTestedAge3039;
    @JsonProperty("people_tested_age_40_49")
    private String peopleTestedAge4049;
    @JsonProperty("people_tested_age_50_59")
    private String peopleTestedAge5059;
    @JsonProperty("people_tested_age_60_69")
    private String peopleTestedAge6069;
    @JsonProperty("people_tested_age_70_79")
    private String peopleTestedAge7079;
    @JsonProperty("people_tested_age_80_")
    private String peopleTestedAge80;
    @JsonProperty("people_tested_age_unknown")
    private String peopleTestedAgeUnknown;
    @JsonProperty("people_tested_female")
    private String peopleTestedFemale;
    @JsonProperty("people_tested_male")
    private String peopleTestedMale;
    @JsonProperty("people_tested_gender_unknown")
    private String peopleTestedGenderUnknown;
    @JsonProperty("people_tested_latinx")
    private String peopleTestedLatinx;
    @JsonProperty("people_tested_asian_non_latinx")
    private String peopleTestedAsianNonLatinx;
    @JsonProperty("people_tested_black_non_latinx")
    private String peopleTestedBlackNonLatinx;
    @JsonProperty("people_tested_white_non_latinx")
    private String peopleTestedWhiteNonLatinx;
    @JsonProperty("people_tested_other_race_non_latinx")
    private String peopleTestedOtherRaceNonLatinx;
    @JsonProperty("people_tested_unknown_race_ethnicity")
    private String peopleTestedUnknownRaceEthnicity;
    @JsonProperty("people_positive_age_0_17")
    private String peoplePositiveAge017;
    @JsonProperty("people_positive_age_18_29")
    private String peoplePositiveAge1829;
    @JsonProperty("people_positive_age_30_39")
    private String peoplePositiveAge3039;
    @JsonProperty("people_positive_age_40_49")
    private String peoplePositiveAge4049;
    @JsonProperty("people_positive_age_50_59")
    private String peoplePositiveAge5059;
    @JsonProperty("people_positive_age_60_69")
    private String peoplePositiveAge6069;
    @JsonProperty("people_positive_age_70_79")
    private String peoplePositiveAge7079;
    @JsonProperty("people_positive_age_80_")
    private String peoplePositiveAge80;
    @JsonProperty("people_positive_age_unknown")
    private String peoplePositiveAgeUnknown;
    @JsonProperty("people_positive_female")
    private String peoplePositiveFemale;
    @JsonProperty("people_positive_male")
    private String peoplePositiveMale;
    @JsonProperty("people_positive_gender_unknown")
    private String peoplePositiveGenderUnknown;
    @JsonProperty("people_positive_latinx")
    private String peoplePositiveLatinx;
    @JsonProperty("people_positive_asian_non_latinx")
    private String peoplePositiveAsianNonLatinx;
    @JsonProperty("people_positive_black_non_latinx")
    private String peoplePositiveBlackNonLatinx;
    @JsonProperty("people_positive_white_non_latinx")
    private String peoplePositiveWhiteNonLatinx;
    @JsonProperty("people_positive_other_race_non_latinx")
    private String peoplePositiveOtherRaceNonLatinx;
    @JsonProperty("people_positive_unknown_race_ethnicity")
    private String peoplePositiveUnknownRaceEthnicity;
    @JsonProperty("people_not_positive_age_0_17")
    private String peopleNotPositiveAge017;
    @JsonProperty("people_not_positive_age_18_29")
    private String peopleNotPositiveAge1829;
    @JsonProperty("people_not_positive_age_30_39")
    private String peopleNotPositiveAge3039;
    @JsonProperty("people_not_positive_age_40_49")
    private String peopleNotPositiveAge4049;
    @JsonProperty("people_not_positive_age_50_59")
    private String peopleNotPositiveAge5059;
    @JsonProperty("people_not_positive_age_60_69")
    private String peopleNotPositiveAge6069;
    @JsonProperty("people_not_positive_age_70_79")
    private String peopleNotPositiveAge7079;
    @JsonProperty("people_not_positive_age_80_")
    private String peopleNotPositiveAge80;
    @JsonProperty("people_not_positive_age_unknown")
    private String peopleNotPositiveAgeUnknown;
    @JsonProperty("people_not_positive_female")
    private String peopleNotPositiveFemale;
    @JsonProperty("people_not_positive_male")
    private String peopleNotPositiveMale;
    @JsonProperty("people_not_positive_gender_unknown")
    private String peopleNotPositiveGenderUnknown;
    @JsonProperty("people_not_positive_latinx")
    private String peopleNotPositiveLatinx;
    @JsonProperty("people_not_positive_asian_non_latinx")
    private String peopleNotPositiveAsianNonLatinx;
    @JsonProperty("people_not_positive_black_non_latinx")
    private String peopleNotPositiveBlackNonLatinx;
    @JsonProperty("people_not_positive_white_non_latinx")
    private String peopleNotPositiveWhiteNonLatinx;
    @JsonProperty("people_not_positive_other_race_non_latinx")
    private String peopleNotPositiveOtherRaceNonLatinx;
    @JsonProperty("people_not_positive_unknown_race_ethnicity")
    private String peopleNotPositiveUnknownRaceEthnicity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    @JsonProperty("people_tested_total")
    public String getPeopleTestedTotal() {
        return peopleTestedTotal;
    }

    @JsonProperty("people_tested_total")
    public void setPeopleTestedTotal(String peopleTestedTotal) {
        this.peopleTestedTotal = peopleTestedTotal;
    }

    @JsonProperty("people_positive_total")
    public String getPeoplePositiveTotal() {
        return peoplePositiveTotal;
    }

    @JsonProperty("people_positive_total")
    public void setPeoplePositiveTotal(String peoplePositiveTotal) {
        this.peoplePositiveTotal = peoplePositiveTotal;
    }

    @JsonProperty("people_not_positive_total")
    public String getPeopleNotPositiveTotal() {
        return peopleNotPositiveTotal;
    }

    @JsonProperty("people_not_positive_total")
    public void setPeopleNotPositiveTotal(String peopleNotPositiveTotal) {
        this.peopleNotPositiveTotal = peopleNotPositiveTotal;
    }

    @JsonProperty("people_tested_age_0_17")
    public String getPeopleTestedAge017() {
        return peopleTestedAge017;
    }

    @JsonProperty("people_tested_age_0_17")
    public void setPeopleTestedAge017(String peopleTestedAge017) {
        this.peopleTestedAge017 = peopleTestedAge017;
    }

    @JsonProperty("people_tested_age_18_29")
    public String getPeopleTestedAge1829() {
        return peopleTestedAge1829;
    }

    @JsonProperty("people_tested_age_18_29")
    public void setPeopleTestedAge1829(String peopleTestedAge1829) {
        this.peopleTestedAge1829 = peopleTestedAge1829;
    }

    @JsonProperty("people_tested_age_30_39")
    public String getPeopleTestedAge3039() {
        return peopleTestedAge3039;
    }

    @JsonProperty("people_tested_age_30_39")
    public void setPeopleTestedAge3039(String peopleTestedAge3039) {
        this.peopleTestedAge3039 = peopleTestedAge3039;
    }

    @JsonProperty("people_tested_age_40_49")
    public String getPeopleTestedAge4049() {
        return peopleTestedAge4049;
    }

    @JsonProperty("people_tested_age_40_49")
    public void setPeopleTestedAge4049(String peopleTestedAge4049) {
        this.peopleTestedAge4049 = peopleTestedAge4049;
    }

    @JsonProperty("people_tested_age_50_59")
    public String getPeopleTestedAge5059() {
        return peopleTestedAge5059;
    }

    @JsonProperty("people_tested_age_50_59")
    public void setPeopleTestedAge5059(String peopleTestedAge5059) {
        this.peopleTestedAge5059 = peopleTestedAge5059;
    }

    @JsonProperty("people_tested_age_60_69")
    public String getPeopleTestedAge6069() {
        return peopleTestedAge6069;
    }

    @JsonProperty("people_tested_age_60_69")
    public void setPeopleTestedAge6069(String peopleTestedAge6069) {
        this.peopleTestedAge6069 = peopleTestedAge6069;
    }

    @JsonProperty("people_tested_age_70_79")
    public String getPeopleTestedAge7079() {
        return peopleTestedAge7079;
    }

    @JsonProperty("people_tested_age_70_79")
    public void setPeopleTestedAge7079(String peopleTestedAge7079) {
        this.peopleTestedAge7079 = peopleTestedAge7079;
    }

    @JsonProperty("people_tested_age_80_")
    public String getPeopleTestedAge80() {
        return peopleTestedAge80;
    }

    @JsonProperty("people_tested_age_80_")
    public void setPeopleTestedAge80(String peopleTestedAge80) {
        this.peopleTestedAge80 = peopleTestedAge80;
    }

    @JsonProperty("people_tested_age_unknown")
    public String getPeopleTestedAgeUnknown() {
        return peopleTestedAgeUnknown;
    }

    @JsonProperty("people_tested_age_unknown")
    public void setPeopleTestedAgeUnknown(String peopleTestedAgeUnknown) {
        this.peopleTestedAgeUnknown = peopleTestedAgeUnknown;
    }

    @JsonProperty("people_tested_female")
    public String getPeopleTestedFemale() {
        return peopleTestedFemale;
    }

    @JsonProperty("people_tested_female")
    public void setPeopleTestedFemale(String peopleTestedFemale) {
        this.peopleTestedFemale = peopleTestedFemale;
    }

    @JsonProperty("people_tested_male")
    public String getPeopleTestedMale() {
        return peopleTestedMale;
    }

    @JsonProperty("people_tested_male")
    public void setPeopleTestedMale(String peopleTestedMale) {
        this.peopleTestedMale = peopleTestedMale;
    }

    @JsonProperty("people_tested_gender_unknown")
    public String getPeopleTestedGenderUnknown() {
        return peopleTestedGenderUnknown;
    }

    @JsonProperty("people_tested_gender_unknown")
    public void setPeopleTestedGenderUnknown(String peopleTestedGenderUnknown) {
        this.peopleTestedGenderUnknown = peopleTestedGenderUnknown;
    }

    @JsonProperty("people_tested_latinx")
    public String getPeopleTestedLatinx() {
        return peopleTestedLatinx;
    }

    @JsonProperty("people_tested_latinx")
    public void setPeopleTestedLatinx(String peopleTestedLatinx) {
        this.peopleTestedLatinx = peopleTestedLatinx;
    }

    @JsonProperty("people_tested_asian_non_latinx")
    public String getPeopleTestedAsianNonLatinx() {
        return peopleTestedAsianNonLatinx;
    }

    @JsonProperty("people_tested_asian_non_latinx")
    public void setPeopleTestedAsianNonLatinx(String peopleTestedAsianNonLatinx) {
        this.peopleTestedAsianNonLatinx = peopleTestedAsianNonLatinx;
    }

    @JsonProperty("people_tested_black_non_latinx")
    public String getPeopleTestedBlackNonLatinx() {
        return peopleTestedBlackNonLatinx;
    }

    @JsonProperty("people_tested_black_non_latinx")
    public void setPeopleTestedBlackNonLatinx(String peopleTestedBlackNonLatinx) {
        this.peopleTestedBlackNonLatinx = peopleTestedBlackNonLatinx;
    }

    @JsonProperty("people_tested_white_non_latinx")
    public String getPeopleTestedWhiteNonLatinx() {
        return peopleTestedWhiteNonLatinx;
    }

    @JsonProperty("people_tested_white_non_latinx")
    public void setPeopleTestedWhiteNonLatinx(String peopleTestedWhiteNonLatinx) {
        this.peopleTestedWhiteNonLatinx = peopleTestedWhiteNonLatinx;
    }

    @JsonProperty("people_tested_other_race_non_latinx")
    public String getPeopleTestedOtherRaceNonLatinx() {
        return peopleTestedOtherRaceNonLatinx;
    }

    @JsonProperty("people_tested_other_race_non_latinx")
    public void setPeopleTestedOtherRaceNonLatinx(String peopleTestedOtherRaceNonLatinx) {
        this.peopleTestedOtherRaceNonLatinx = peopleTestedOtherRaceNonLatinx;
    }

    @JsonProperty("people_tested_unknown_race_ethnicity")
    public String getPeopleTestedUnknownRaceEthnicity() {
        return peopleTestedUnknownRaceEthnicity;
    }

    @JsonProperty("people_tested_unknown_race_ethnicity")
    public void setPeopleTestedUnknownRaceEthnicity(String peopleTestedUnknownRaceEthnicity) {
        this.peopleTestedUnknownRaceEthnicity = peopleTestedUnknownRaceEthnicity;
    }

    @JsonProperty("people_positive_age_0_17")
    public String getPeoplePositiveAge017() {
        return peoplePositiveAge017;
    }

    @JsonProperty("people_positive_age_0_17")
    public void setPeoplePositiveAge017(String peoplePositiveAge017) {
        this.peoplePositiveAge017 = peoplePositiveAge017;
    }

    @JsonProperty("people_positive_age_18_29")
    public String getPeoplePositiveAge1829() {
        return peoplePositiveAge1829;
    }

    @JsonProperty("people_positive_age_18_29")
    public void setPeoplePositiveAge1829(String peoplePositiveAge1829) {
        this.peoplePositiveAge1829 = peoplePositiveAge1829;
    }

    @JsonProperty("people_positive_age_30_39")
    public String getPeoplePositiveAge3039() {
        return peoplePositiveAge3039;
    }

    @JsonProperty("people_positive_age_30_39")
    public void setPeoplePositiveAge3039(String peoplePositiveAge3039) {
        this.peoplePositiveAge3039 = peoplePositiveAge3039;
    }

    @JsonProperty("people_positive_age_40_49")
    public String getPeoplePositiveAge4049() {
        return peoplePositiveAge4049;
    }

    @JsonProperty("people_positive_age_40_49")
    public void setPeoplePositiveAge4049(String peoplePositiveAge4049) {
        this.peoplePositiveAge4049 = peoplePositiveAge4049;
    }

    @JsonProperty("people_positive_age_50_59")
    public String getPeoplePositiveAge5059() {
        return peoplePositiveAge5059;
    }

    @JsonProperty("people_positive_age_50_59")
    public void setPeoplePositiveAge5059(String peoplePositiveAge5059) {
        this.peoplePositiveAge5059 = peoplePositiveAge5059;
    }

    @JsonProperty("people_positive_age_60_69")
    public String getPeoplePositiveAge6069() {
        return peoplePositiveAge6069;
    }

    @JsonProperty("people_positive_age_60_69")
    public void setPeoplePositiveAge6069(String peoplePositiveAge6069) {
        this.peoplePositiveAge6069 = peoplePositiveAge6069;
    }

    @JsonProperty("people_positive_age_70_79")
    public String getPeoplePositiveAge7079() {
        return peoplePositiveAge7079;
    }

    @JsonProperty("people_positive_age_70_79")
    public void setPeoplePositiveAge7079(String peoplePositiveAge7079) {
        this.peoplePositiveAge7079 = peoplePositiveAge7079;
    }

    @JsonProperty("people_positive_age_80_")
    public String getPeoplePositiveAge80() {
        return peoplePositiveAge80;
    }

    @JsonProperty("people_positive_age_80_")
    public void setPeoplePositiveAge80(String peoplePositiveAge80) {
        this.peoplePositiveAge80 = peoplePositiveAge80;
    }

    @JsonProperty("people_positive_age_unknown")
    public String getPeoplePositiveAgeUnknown() {
        return peoplePositiveAgeUnknown;
    }

    @JsonProperty("people_positive_age_unknown")
    public void setPeoplePositiveAgeUnknown(String peoplePositiveAgeUnknown) {
        this.peoplePositiveAgeUnknown = peoplePositiveAgeUnknown;
    }

    @JsonProperty("people_positive_female")
    public String getPeoplePositiveFemale() {
        return peoplePositiveFemale;
    }

    @JsonProperty("people_positive_female")
    public void setPeoplePositiveFemale(String peoplePositiveFemale) {
        this.peoplePositiveFemale = peoplePositiveFemale;
    }

    @JsonProperty("people_positive_male")
    public String getPeoplePositiveMale() {
        return peoplePositiveMale;
    }

    @JsonProperty("people_positive_male")
    public void setPeoplePositiveMale(String peoplePositiveMale) {
        this.peoplePositiveMale = peoplePositiveMale;
    }

    @JsonProperty("people_positive_gender_unknown")
    public String getPeoplePositiveGenderUnknown() {
        return peoplePositiveGenderUnknown;
    }

    @JsonProperty("people_positive_gender_unknown")
    public void setPeoplePositiveGenderUnknown(String peoplePositiveGenderUnknown) {
        this.peoplePositiveGenderUnknown = peoplePositiveGenderUnknown;
    }

    @JsonProperty("people_positive_latinx")
    public String getPeoplePositiveLatinx() {
        return peoplePositiveLatinx;
    }

    @JsonProperty("people_positive_latinx")
    public void setPeoplePositiveLatinx(String peoplePositiveLatinx) {
        this.peoplePositiveLatinx = peoplePositiveLatinx;
    }

    @JsonProperty("people_positive_asian_non_latinx")
    public String getPeoplePositiveAsianNonLatinx() {
        return peoplePositiveAsianNonLatinx;
    }

    @JsonProperty("people_positive_asian_non_latinx")
    public void setPeoplePositiveAsianNonLatinx(String peoplePositiveAsianNonLatinx) {
        this.peoplePositiveAsianNonLatinx = peoplePositiveAsianNonLatinx;
    }

    @JsonProperty("people_positive_black_non_latinx")
    public String getPeoplePositiveBlackNonLatinx() {
        return peoplePositiveBlackNonLatinx;
    }

    @JsonProperty("people_positive_black_non_latinx")
    public void setPeoplePositiveBlackNonLatinx(String peoplePositiveBlackNonLatinx) {
        this.peoplePositiveBlackNonLatinx = peoplePositiveBlackNonLatinx;
    }

    @JsonProperty("people_positive_white_non_latinx")
    public String getPeoplePositiveWhiteNonLatinx() {
        return peoplePositiveWhiteNonLatinx;
    }

    @JsonProperty("people_positive_white_non_latinx")
    public void setPeoplePositiveWhiteNonLatinx(String peoplePositiveWhiteNonLatinx) {
        this.peoplePositiveWhiteNonLatinx = peoplePositiveWhiteNonLatinx;
    }

    @JsonProperty("people_positive_other_race_non_latinx")
    public String getPeoplePositiveOtherRaceNonLatinx() {
        return peoplePositiveOtherRaceNonLatinx;
    }

    @JsonProperty("people_positive_other_race_non_latinx")
    public void setPeoplePositiveOtherRaceNonLatinx(String peoplePositiveOtherRaceNonLatinx) {
        this.peoplePositiveOtherRaceNonLatinx = peoplePositiveOtherRaceNonLatinx;
    }

    @JsonProperty("people_positive_unknown_race_ethnicity")
    public String getPeoplePositiveUnknownRaceEthnicity() {
        return peoplePositiveUnknownRaceEthnicity;
    }

    @JsonProperty("people_positive_unknown_race_ethnicity")
    public void setPeoplePositiveUnknownRaceEthnicity(String peoplePositiveUnknownRaceEthnicity) {
        this.peoplePositiveUnknownRaceEthnicity = peoplePositiveUnknownRaceEthnicity;
    }

    @JsonProperty("people_not_positive_age_0_17")
    public String getPeopleNotPositiveAge017() {
        return peopleNotPositiveAge017;
    }

    @JsonProperty("people_not_positive_age_0_17")
    public void setPeopleNotPositiveAge017(String peopleNotPositiveAge017) {
        this.peopleNotPositiveAge017 = peopleNotPositiveAge017;
    }

    @JsonProperty("people_not_positive_age_18_29")
    public String getPeopleNotPositiveAge1829() {
        return peopleNotPositiveAge1829;
    }

    @JsonProperty("people_not_positive_age_18_29")
    public void setPeopleNotPositiveAge1829(String peopleNotPositiveAge1829) {
        this.peopleNotPositiveAge1829 = peopleNotPositiveAge1829;
    }

    @JsonProperty("people_not_positive_age_30_39")
    public String getPeopleNotPositiveAge3039() {
        return peopleNotPositiveAge3039;
    }

    @JsonProperty("people_not_positive_age_30_39")
    public void setPeopleNotPositiveAge3039(String peopleNotPositiveAge3039) {
        this.peopleNotPositiveAge3039 = peopleNotPositiveAge3039;
    }

    @JsonProperty("people_not_positive_age_40_49")
    public String getPeopleNotPositiveAge4049() {
        return peopleNotPositiveAge4049;
    }

    @JsonProperty("people_not_positive_age_40_49")
    public void setPeopleNotPositiveAge4049(String peopleNotPositiveAge4049) {
        this.peopleNotPositiveAge4049 = peopleNotPositiveAge4049;
    }

    @JsonProperty("people_not_positive_age_50_59")
    public String getPeopleNotPositiveAge5059() {
        return peopleNotPositiveAge5059;
    }

    @JsonProperty("people_not_positive_age_50_59")
    public void setPeopleNotPositiveAge5059(String peopleNotPositiveAge5059) {
        this.peopleNotPositiveAge5059 = peopleNotPositiveAge5059;
    }
}