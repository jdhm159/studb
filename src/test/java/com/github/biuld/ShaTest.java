package com.github.biuld;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

import com.github.biuld.util.Encrypt;
import com.github.biuld.util.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Scanner;
import javax.swing.text.Style;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;



@SpringBootTest
public class ShaTest {
  @Test
  public void sha(){
    Time time = new Time();
    System.out.println(time.getTodayBegin());
    System.out.println(LocalDateTime.now());
    System.out.println("The square root of \u03C0 is " + sqrt(PI));

    Scanner in = new Scanner(System.in);
    System.out.println(in.nextLine());
  }
}
