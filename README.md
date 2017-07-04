<h1>Spark java picture download android client</h1>

<h3>build.gradle</h3>

```gradle
allprojects {
    repositories {
        jcenter()
        maven {url "https://jitpack.io"}
    }
}
```

<h3>build.gradle (app)</h3>

```gradle
dependencies {
    ...
    compile 'com.github.pethoalpar:HttpUrlConnectionModule:v0.3'
    ...
}
```

<h3>Main.java</h3>

```java
HttpCall httpCall = new HttpCall();
httpCall.setMethodtype(HttpCall.GET);
httpCall.setReturnTye(HttpCall.BYTE_ARRAY);
httpCall.setUrl("http://192.168.0.103:7676/pic/2");
new HttpRequest(){
    @Override
    public void onResponseByteArray(byte[] response) {
        if(response!=null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(response, 0, response.length);            
        }
    }
}.execute(httpCall);
```
