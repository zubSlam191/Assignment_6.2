package com.emailprocessing.email.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2016/04/04.
 */
public class Contact implements Serializable {
    String address;
    String nickname;
    Date lastSeen;

    public Contact(String address, String nickname, Date lastSeen) {
        this.address = address;
        this.nickname = nickname;
        this.lastSeen = lastSeen;
    }

    public Contact(Builder builder) {
        this.address = builder.address;
        this.nickname = builder.nickname;
        this.lastSeen = builder.lastSeen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public static class Builder{
        String address;
        String nickname;
        Date lastSeen;

        public Builder address(String value){
            this.address = value;
            return this;
        }

        public Builder nickname(String value){
            this.nickname = value;
            return this;
        }

        public Builder lastSeen(Date value) {
            this.lastSeen = value;
            return this;
        }

        public Builder copy(Contact value) {
            this.address = value.getAddress();
            this.nickname = value.getNickname();
            this.lastSeen = value.getLastSeen();
            return this;
        }

        public Contact build() {
            return new Contact(this) {
                
            };
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address='" + address + '\'' +
                ", nickname='" + nickname + '\'' +
                ", lastSeen=" + lastSeen +
                '}';
    }
}
