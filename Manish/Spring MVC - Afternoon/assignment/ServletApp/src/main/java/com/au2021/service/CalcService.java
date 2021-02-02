package com.au2021.service;

import com.au2021.Exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int calc(String a, String b, String opr) throws DivideByZeroException {
        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(b);
        if (n2 == 0) throw new DivideByZeroException();

        switch (opr) {
            case "add": {
                return n1 + n2;
            }
            case "sub": {
                return n1 - n2;
            }
            case "mul": {
                return n1 * n2;
            }
            case "div": {
                return n1 / n2;
            }
        }

        return 0;
    }
}
