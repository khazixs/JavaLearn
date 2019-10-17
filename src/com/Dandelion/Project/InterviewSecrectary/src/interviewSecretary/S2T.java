package com.Dandelion.Project.InterviewSecrectary.src.interviewSecretary;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.apache.log4j.PropertyConfigurator;

import com.alibaba.fastjson.JSON;
import com.iflytek.msp.cpdb.lfasr.client.LfasrClientImp;
import com.iflytek.msp.cpdb.lfasr.exception.LfasrException;
import com.iflytek.msp.cpdb.lfasr.model.LfasrType;
import com.iflytek.msp.cpdb.lfasr.model.Message;
import com.iflytek.msp.cpdb.lfasr.model.ProgressStatus;

public class S2T {
	// ԭʼ��Ƶ��ŵ�ַ
		private String input_file = "";
		/*
		 * תд����ѡ�񣺱�׼��͵绰��ֱ�Ϊ��
		 * LfasrType.LFASR_STANDARD_RECORDED_AUDIO �� LfasrType.LFASR_TELEPHONY_RECORDED_AUDIO
		 * */
		private LfasrType type = LfasrType.LFASR_STANDARD_RECORDED_AUDIO;
		// �ȴ�ʱ�����룩
		private int sleepSecond = 20;
	
	S2T(String default_inpath_value){
		input_file = default_inpath_value.replace("\\", "\\\\");
	}
	
	public String start(){
		
		// ��ʼ��LFASRʵ��
		LfasrClientImp lc = null;
		try {
			lc = LfasrClientImp.initLfasrClient();
			} catch (LfasrException e) {
				// ��ʼ���쳣�������쳣������Ϣ
				Message initMsg = JSON.parseObject(e.getMessage(), Message.class);
				System.out.println("Hello 1");
				return "ecode=" + initMsg.getErr_no()+" || "+"failed=" + initMsg.getFailed();
			}
		
		// ��ȡ�ϴ�����ID
		String task_id = "";
		HashMap<String, String> params = new HashMap<>();
		params.put("has_participle", "true");
		try {
			// �ϴ���Ƶ�ļ�
			Message uploadMsg = lc.lfasrUpload(input_file, type, params);
			
			// �жϷ���ֵ
			int ok = uploadMsg.getOk();
			if (ok == 0) {} 
			else {
				// ��������ʧ��-������쳣
				System.out.println("Hello 2");
				return "ecode=" +  uploadMsg.getErr_no()+" || "+"failed=" +  uploadMsg.getFailed();
				}
			} catch (LfasrException e) {
				// �ϴ��쳣�������쳣������Ϣ
				System.out.println("Hello 3");
				Message uploadMsg = JSON.parseObject(e.getMessage(), Message.class);
				return "ecode=" +  uploadMsg.getErr_no()+" || "+"failed=" +  uploadMsg.getFailed();
				}
						
				// ѭ���ȴ���Ƶ������
				while (true) {
					try {
						// ˯��1min������һ�����������û����Զ�λ�ȡ����һ�μ����1���ӣ���ȡ�ɹ���break��ʧ�ܵĻ����ӵ�2�����ٻ�ȡ����ȡ�ɹ���break����ʧ�ܵĻ��ӵ�4���ӣ�8���ӣ�����
						Thread.sleep(sleepSecond * 1000);
						//System.out.println("waiting ...");
					} catch (InterruptedException e) {System.out.println("Hello 4");}
					try {
						// ��ȡ�������
						Message progressMsg = lc.lfasrGetProgress(task_id);
								
						// �������״̬������0��������ʧ��
						if (progressMsg.getOk() != 0) {
							/*System.out.println("task was fail. task_id:" + task_id);
							System.out.println("ecode=" + progressMsg.getErr_no());
							System.out.println("failed=" + progressMsg.getFailed());*/
							
							// ����˴����쳣-������ڲ������Ի��ƣ����Ų鼫���޷��ָ�������
							// �ͻ��˿ɸ���ʵ�����ѡ��
							// 1. �ͻ���ѭ�����Ի�ȡ����
							// 2. �˳����򣬷�������
							continue;
						} else {
							ProgressStatus progressStatus = JSON.parseObject(progressMsg.getData(), ProgressStatus.class);
							if (progressStatus.getStatus() == 9) {
								// �������
								//System.out.println("task was completed. task_id:" + task_id);
								System.out.println("Hello 5");
								break;	
							} else {
								// δ�������
								//System.out.println("task was incomplete. task_id:" + task_id + ", status:" + progressStatus.getDesc());
								System.out.println("Hello 6");
								continue;
							}
						}
					} catch (LfasrException e) {
						// ��ȡ�����쳣�������ݷ�����Ϣ�Ų�������ٴν��л�ȡ
						System.out.println("Hello 7");
						Message progressMsg = JSON.parseObject(e.getMessage(), Message.class);
						return "ecode=" +  progressMsg.getErr_no()+" || "+"failed=" +  progressMsg.getFailed();
					}
				}

				// ��ȡ������
				try {
					Message resultMsg = lc.lfasrGetResult(task_id);
					//System.out.println(resultMsg.getData());	
					// �������״̬����0����������ɹ�
					if (resultMsg.getOk() == 0) {
						// ��ӡתд���
						//System.out.println(resultMsg.getData());
						return resultMsg.getData();
					} else {
						// תдʧ�ܣ�����ʧ����Ϣ���д���
						System.out.println("Hello 8");
						return "ecode=" +  resultMsg.getErr_no()+" || "+"failed=" +  resultMsg.getFailed();
					}
				} catch (LfasrException e) {
					// ��ȡ����쳣���������쳣������Ϣ
					System.out.println("Hello 9");
					Message resultMsg = JSON.parseObject(e.getMessage(), Message.class);
					return "ecode=" +  resultMsg.getErr_no()+" || "+"failed=" +  resultMsg.getFailed();
				}
			}
}
