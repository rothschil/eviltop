//package io.github.rothschil.queue.handler;
//
//import io.github.rothschil.base.aop.queue.handler.TaskHandlerble;
//import io.github.rothschil.domain.entity.NgxLog;
//import io.github.rothschil.domain.service.NgxLogService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class NgxLogHandler implements TaskHandlerble {
//
//    public NgxLogService ngxLogService;
//
//    private List<NgxLog> logList;
//
//    @Override
//    public void process() {
//        ngxLogService.insertBatchByOn(logList) ;
//    }
//
//    public NgxLogHandler(List<NgxLog> logList){
//        this.logList = logList;
//    }
//
//    @Autowired
//    public void setNgxLogService(NgxLogService ngxLogService) {
//        this.ngxLogService = ngxLogService;
//    }
//
//}
