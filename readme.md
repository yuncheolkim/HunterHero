## proto

---- mac

protoc --java_out=/Users/jinyunzhe/develop/gitee/HunterHero/src/main/java --proto_path=/Users/jinyunzhe/develop/gitee/HunterHero/proto /Users/jinyunzhe/develop/gitee/HunterHero/proto/*.proto

protoc --csharp_out=/Users/jinyunzhe/develop/unity/WindLand/Assets/Scripts/net/proto --proto_path=/Users/jinyunzhe/develop/gitee/HunterHero/proto /Users/jinyunzhe/develop/gitee/HunterHero/proto/*.proto

---- windows

### java

F:\tools\protoc.exe --java_out=F:\gitee\HunterHero\src\main\java --proto_path=F:\gitee\HunterHero\proto F:\gitee\HunterHero\proto\*.proto

### unity

F:\tools\protoc.exe --csharp_out=E:\unity_project\HerosHunter\Assets\Scripts\net\proto --proto_path=F:\gitee\HunterHero\proto F:\gitee\HunterHero\proto\*.proto

## excel

---- mac

./excelTool -inDir /Users/jinyunzhe/develop/gitee/hunter-hero-config -outDir /Users/jinyunzhe/develop/gitee/HunterHero/src/main/resources/data

./excelTool -inDir /Users/jinyunzhe/develop/gitee/hunter-hero-config -outDir /Users/jinyunzhe/develop/unity/WindLand/Assets/Resources/Data

---- windows

### java

F:\tools\excel.exe -inDir F:\gitee\hunter-hero-config -outDir F:\gitee\HunterHero\src\main\resources\data

### unity

F:\tools\excel.exe -inDir F:\gitee\hunter-hero-config -outDir E:\unity_project\HerosHunter\Assets\Resources\Data

## all

F:\tools\protoc.exe --java_out=F:\gitee\HunterHero\src\main\java --proto_path=F:\gitee\HunterHero\proto F:\gitee\HunterHero\proto\*.proto

F:\tools\protoc.exe --csharp_out=E:\unity_project\HerosHunter\Assets\Scripts\net\proto --proto_path=F:\gitee\HunterHero\proto F:\gitee\HunterHero\proto\*.proto

F:\tools\excel.exe -inDir F:\gitee\hunter-hero-config -outDir F:\gitee\HunterHero\src\main\resources\data

F:\tools\excel.exe -inDir F:\gitee\hunter-hero-config -outDir E:\unity_project\HerosHunter\Assets\Resources\Data

Data + Service

## ip

111.229.175.151

## port

### tcp
9001

### http
7000

java -jar  --add-opens java.base/java.lang=ALL-UNNAMED -Dio.netty.tryReflectionSetAccessible=true  .\game-server-1.0.0.jar 
