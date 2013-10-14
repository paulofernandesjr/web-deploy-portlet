package br.com.liferay.portlet.webdeploy;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class WebDeploy
 */
public class WebDeploy extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String props = PropsUtil.get("auto.deploy.enabled");
		renderRequest.setAttribute("canDeploy", new Boolean(props));

		super.doView(renderRequest, renderResponse);
	}

	public void submitFile(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		String submissionFileName = uploadRequest.getFileName("file");
		File submissionFile = uploadRequest.getFile("file");

		String props = PropsUtil.get("auto.deploy.deploy.dir");
	
		File source = submissionFile;
		File destination = new File(props.concat(submissionFileName));

		FileUtil.copyFile(source, destination);
	}
	
}
