package mwt.twitterstreams

object IngestApp extends App with Logging {
  log.info(Settings.config.toString)

  val source = Settings.getHosebirdMsgSource
  val sink = Settings.getKafkaSink

  while(!source.hosebirdClient.isDone) {
    source.take() match {
      case Some(json) => sink.send(json)
      case None =>
    }
  }

}