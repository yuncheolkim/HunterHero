#!/usr/bin/env bash

rm -fr /Users/jinyunzhe/develop/gitee/HunterHero/src/main/java/game/proto
protoc --java_out=/Users/jinyunzhe/develop/gitee/HunterHero/src/main/java --proto_path=/Users/jinyunzhe/develop/gitee/HunterHero/proto /Users/jinyunzhe/develop/gitee/HunterHero/proto/*.proto
