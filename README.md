# SpringAndroidDemo

A Simple project that demos the utility of Spring for Android when used with Gson.
 
# Utilities Used
* ButterKnife for View injection
* Spring-android features 
  1. A Rest Client for Android
  2. Auth support for accessing secure APIs
* Gson for JSON to Java object conversion (used by spring-android)


# Steps Involved
1. Initialize RestTemplate
```Java
private RestTemplate restTemplate = new RestTemplate();
```
2. Add Gson convertor to RestTemple Messageconverter. Do this in `onCreate(..)` method
```Java
restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
```
3. Hit the URL and pass Java class type to which the result is to be converted
```Java
final ICNDBJoke joke = restTemplate.getForObject(URL, ICNDBJoke.class);
```

# REST Service that can be used for Demo purposes
* [The Internet Chuck Norris Database](http://www.icndb.com/api/)
    - This one requires no authentication and so is easier for quick demo purposes
* [Open Weather Map](http://openweathermap.org/api)
    - To access the API you need to sign up for an API key if you are on a free or paid plan.
* [NFLArrest API](http://nflarrest.com/api/)
    - This one requires no authentication and so is easier for quick demo purposes. Requires some domain knowledge to get a hang of the context.
* [jsonrates – Currency exchange rates JSON API](http://jsonrates.com/) 
