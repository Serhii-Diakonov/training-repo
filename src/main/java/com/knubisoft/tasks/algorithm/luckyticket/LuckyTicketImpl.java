package com.knubisoft.tasks.algorithm.luckyticket;

import java.util.regex.Pattern;

public class LuckyTicketImpl implements LuckyTicket {
    @Override
    public boolean checkIsLuckyTicket(String ticket) {
        return ticket != null &&
                Pattern.matches("\\d{6,8}", ticket) &&
                new StringBuilder(ticket).reverse().toString().equals(ticket);
    }
}
