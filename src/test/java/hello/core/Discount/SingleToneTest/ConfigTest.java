package hello.core.Discount.SingleToneTest;

public class ConfigTest {

//    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//    MemberService memberService = applicationContext.getBean("test", MemberService.class);
//    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
//    @Test
//    @DisplayName("싱글톤 테스트")
//    void SingleTest()
//    {
//        //System.out.println(memberService);
//        //System.out.println(orderService);
//        // 서로 다른 객체 생성됨
//        assertThat(memberService).isEqualTo(orderService);
//    }

    // static은 하나만 생성됨, 전역으로 사용 가능
    private static final ConfigTest instance = new ConfigTest();

    public static ConfigTest getInstance() {
        return instance;
    }

    private ConfigTest(){

    }

    public void LoginTest(){
        System.out.println("테스트해보기");
    }

}
