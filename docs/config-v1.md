{
  "channels": {
    /** 用户名 客户端唯一标识 */
    "channel-name-zzt": {
      /** 服务唯一标识 */
      "default": {
        "name": "default-service",
        "public-port": 9111,
        "private-address": "192.168.1.9",
        "private-port:": 8080
      },
      "service-1": {
        "name": "service-1",
        "public-port": 9111,
        "private-address": "192.168.1.12",
        "private-port:": 8080
      }
    },
    "channel-name-fullee": {
      "default": {
        "name": "default-service",
        "public-port": 9111,
        "private-address": "192.168.1.9",
        "private-port:": 8080
      },
      "service-1": {
        "name": "service-1",
        "public-port": 9111,
        "private-address": "192.168.1.12",
        "private-port:": 8080
      }
    }
  },
  "client": {
    "config": true
  },
  "server": {
    "port": 8080,
    "web-port": 8011
  },
  "version": "1.0"
}