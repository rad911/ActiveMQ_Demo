# ActiveMQ_Demo

ActiveMQ的入门demo

知识：
JMS 定义了5中不同的消息正文格式，以及调用的消息类型，允许你发送并接收一些不同形式的数据，提供现有的消息格式的一些级别的兼容性。
TextMessage:一个字符串对象
MapMessage:键值对
ObjectMessage：一个序列化Java对象
BytesMessage:一个字节的数据流
StreamMessage:Java原始值的数据流

JMS消息传递类型
 1.点对点(动作只需要执行一次)
 2.消息订阅模式(需要在每一个结点都用到，具有实时性，如果消费者在生产者生产时，没启动，则接收不到信息)
