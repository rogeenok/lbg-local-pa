package org.best.saintpetersburg.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "members_personalinfo")
@Data
public class MemberPersonalInfo {

    @Id
    private String id;
    private String accountID;           // id аккаунта бестика

    // имя бестика
    private String firstNameRus;
    private String lastNameRus;
    private String firstNameEng;
    private String lastNameEng;

    // контакты бестика
    private String phoneNumber;
    private String email;

    // статус бестика
    //private MonthOfStart monthOfStart;        // будет с Десериализатором как enum!
    private String monthOfStart;
    private String yearOfStart;
    private String status;              // статус бестика (в борде)     -- ПРЕВРАТИТЬ в enum
    private List<String> fields;        // места занятости бестика      -- ПРЕВРАТИТЬ В список из enum
    private String statusInBEST;        // статус бестика в лбг (observer, baby, full, alumni etc.) -- ПРЕВРАТИТЬ В enum

    // день рождения бестика
    private String birthday;

    // ангел бестика (мама или папа)
    private String angelID;             // id ангела в бд
    private String angelName;           // имя в формате Имя Фамилия

    // где учится бестик
    private String institution;         // ПРЕВРАТИТЬ В enum
    private String groupNumber;

    // ссылки на соц. сети
    private String vkontakteProfile;
    private String facebookProfile;
    private String instagramProfile;

    private enum MonthOfStart {

        JANUARY ("January"),
        FEBRUARY ("February"),
        MARCH ("March"),
        APRIL ("April"),
        MAY ("May"),
        JUNE ("June");

        private String month;

        MonthOfStart(String month) {
            this.month = month;
        }

        public String getMonth() {
            return month;
        }

        @Override
        public String toString() {
            return getMonth();
        }
    }
}
