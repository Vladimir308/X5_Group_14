package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})

public interface WebConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://www.x5.ru")
    String getBaseUrl();

    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("132.0")
    String getBrowserVersion();

    @Key("selenoidUser")
    String selenoidUser();

    @Key("selenoidPassword")
    String selenoidPassword();

    @Key("selenoidHost")
    String selenoidHost();

    @Key("remoteUrl")
    String getRemoteUrl();
}