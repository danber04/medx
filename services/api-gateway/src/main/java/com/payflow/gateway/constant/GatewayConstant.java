package com.payflow.gateway.constant;

public final class GatewayConstant {

    private GatewayConstant() {
    }

    /**
     * Headers to be passed to downstream services
     */
    public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";
    public static final String REQUEST_TIME_HEADER = "X-Request-Time";
    public static final String GATEWAY_SOURCE_HEADER = "X-Gateway-Source";
    public static final String GATEWAY_SOURCE_VALUE = "iconic-api-gateway";

    /**
     * Route id's
     */
    public static final String ROUTE_USER_SERVICE = "user-service-route";
    public static final String ROUTE_SALON_SERVICE = "salon-service-route";
    public static final String ROUTE_CATEGORY_SERVICE = "category-service-route";
    public static final String ROUTE_OFFERING_SERVICE = "service-offering-route";
    public static final String ROUTE_BOOKING_SERVICE = "booking-service-route";
    public static final String ROUTE_PAYMENT_SERVICE = "payment-service-route";
    public static final String ROUTE_REVIEW_SERVICE = "review-service-route";

    /**
     * Circuit breaker names
     */
    public static final String CB_USER_SERVICE = "userServiceCB";
    public static final String CB_SALON_SERVICE = "salonServiceCB";
    public static final String CB_BOOKING_SERVICE = "bookingServiceCB";
    public static final String CB_PAYMENT_SERVICE = "paymentServiceCB";
    public static final String CB_REVIEW_SERVICE = "reviewServiceCB";

    /**
     * Fallback URL's
     */
    public static final String FALLBACK_URI = "forward:/fallback";

    /**
     * Path prefixes
     */
    public static final String API_PREFIX = "/api/v1";
    public static final String USER_PATH = API_PREFIX + "/users/**";
    public static final String SALON_PATH = API_PREFIX + "/salons/**";
    public static final String CATEGORY_PATH = API_PREFIX + "/categories/**";
    public static final String OFFERING_PATH = API_PREFIX + "/offerings/**";
    public static final String BOOKING_PATH = API_PREFIX + "/bookings/**";
    public static final String PAYMENT_PATH = API_PREFIX + "/payments/**";
    public static final String REVIEW_PATH = API_PREFIX + "/reviews/**";

    /**
     * Eureka service IDs and this must match spring.application.name in each microservice's
     * application.yml
     */
    public static final String SVC_USER = "lb://user-service";
    public static final String SVC_SALON = "lb://salon-service";
    public static final String SVC_CATEGORY = "lb://category-service";
    public static final String SVC_OFFERING = "lb://service-offering-service";
    public static final String SVC_BOOKING = "lb://booking-service";
    public static final String SVC_PAYMENT = "lb://payment-service";
    public static final String SVC_REVIEW = "lb://review-service";
}