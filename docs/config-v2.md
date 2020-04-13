```
{
  "channels": {
    "channel-name-zzt": {
      "token": "DSDF-515D-SFS6-54FD",
      "default": {
        "name": "default-service",
        /** 代理域名 统一访问80 或443端口 */
        "proxy-domain": "xf3dsffs3.acl.oskworks.com",
        "private-address": "192.168.1.9",
        "private-port:": 8080
      },
      "service-1": {
        "name": "service-1",
        "proxy-domain": "xf3dsfdfs3.acl.oskworks.com",
        /** 用户自定义域名 代理域名和自定义域名同时生效 */
        "custom-domain": "www.wangkai.com",
        "private-address": "192.168.1.12",
        "private-port:": 8080
      }
    },
    "channel-name-fullee": {
      "token": "DSDF-515D-SFS6-54FD",
      "default": {
        "name": "default-service",
        "proxy-domain": "xf3dsfsfs3.acl.oskworks.com",
        "private-address": "192.168.1.9",
        "private-port:": 8080
      },
      "service-1": {
        "name": "service-1",
        "proxy-domain": "dsffs3.acl.oskworks.com",
        "private-address": "192.168.1.12",
        "private-port:": 8080
      }
    }
  },
  "client": {
  /** 启用客户端配置，将优先使用链接时上传的配置 */
    "config": true
  },
  "server": {
    "port": 8080,
    /** 如配置此项则开启web控制台 */
    "web-port": 8011
  },
  "version": "1.2"
}
```


### 客户端配置
```json
[
    {
            "name": "service-1",
            "public-port": 9000,
    //        "proxy-domain": "dsffs3.acl.oskworks.com",
            "private-address": "192.168.1.13",
            "private-port:": 8080,
            "token": "DSDF-515D-SFS6-541D"
    },
    {
            "name": "service-2",
            "public-port": 9000,
    //        "proxy-domain": "dsffs3.acl.oskworks.com",
            "private-address": "192.168.1.12",
            "private-port:": 8080,
            "token": "DSDF-515D-SFS6-54FD"
    }
]
```

### 协议
协议版本

### 物联网设备管理
