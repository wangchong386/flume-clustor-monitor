
CREATE TABLE `flumeClustor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host` VARCHAR(20) DEFAULT NULL,
  `agent` VARCHAR(100) DEFAULT NULL,
  `role` VARCHAR(100) DEFAULT NULL,
  `roleName` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `flumeSource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host` VARCHAR(20) DEFAULT NULL,
  `agent` VARCHAR(100) DEFAULT NULL,
  `role` VARCHAR(100) DEFAULT NULL,
  `eventReceivedCount` BIGINT(20) DEFAULT NULL,
  `type` VARCHAR(20) DEFAULT NULL,
  `appendBatchAcceptedCount` BIGINT(20) DEFAULT NULL,
  `eventAcceptedCount` BIGINT(20) DEFAULT NULL,
  `appendReceivedCount` BIGINT(20) DEFAULT NULL,
  `startTime`VARCHAR(20) DEFAULT NULL,
  `appendAcceptedCount` BIGINT(20) DEFAULT NULL,
  `openConnectionCount` BIGINT(20) DEFAULT NULL,
  `appendBatchReceivedCount` BIGINT(20) DEFAULT NULL,
  `stopTime`VARCHAR(20) DEFAULT NULL,
  `curTime` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `flumeChannel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host` VARCHAR(20) DEFAULT NULL,
  `agent` VARCHAR(100) DEFAULT NULL,
  `role` VARCHAR(100) DEFAULT NULL,
  `channelCapacity` BIGINT(20) DEFAULT NULL,
  `channelFillPercentage` double(16,2) DEFAULT NULL,
  `type` VARCHAR(20) DEFAULT NULL,
  `channelSize` BIGINT(20) DEFAULT NULL,
  `eventTakeSuccessCount` BIGINT(20) DEFAULT NULL,
  `eventTakeAttemptCount` BIGINT(20) DEFAULT NULL,
  `startTime`VARCHAR(20) DEFAULT NULL,
  `eventPutAttemptCount` BIGINT(20) DEFAULT NULL,
  `eventPutSuccessCount` BIGINT(20) DEFAULT NULL,
  `stopTime`VARCHAR(20) DEFAULT NULL,
  `curTime` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `flumeSink` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host` VARCHAR(20) DEFAULT NULL,
  `agent` VARCHAR(100) DEFAULT NULL,
  `role` VARCHAR(100) DEFAULT NULL,
  `connectionCreatedCount` BIGINT(20) DEFAULT NULL,
  `type` VARCHAR(20) DEFAULT NULL,
  `connectionClosedCount` BIGINT(20) DEFAULT NULL,
  `batchCompleteCount` BIGINT(20) DEFAULT NULL,
  `batchEmptyCount` BIGINT(20) DEFAULT NULL,
  `eventDrainAttemptCount` BIGINT(20) DEFAULT NULL,
  `startTime`VARCHAR(20) DEFAULT NULL,
  `eventDrainSuccessCount` BIGINT(20) DEFAULT NULL,
  `batchUnderflowCount` BIGINT(20) DEFAULT NULL,
  `stopTime`VARCHAR(20) DEFAULT NULL,
  `connectionFailedCount` BIGINT(20) DEFAULT NULL,
  `curTime` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
