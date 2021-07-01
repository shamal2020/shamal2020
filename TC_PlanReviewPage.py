# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
import time

# Our imports
from Login import Login, Logout
from Nav import Nav, navToSublink
from constants import constPaths # paths that should never change

# driver = webdriver.Chrome()
# driver.get('https://python.org')


# from builtins import True
# ---------------------------- #
# Settings - Change as needed #
# --------------------------- #
useBrowser = 'chrome' #edge, chrome
maxWindowOnLoad = True
closeBrowserWhenFinished = False
defaultWaitTime = 10 # seconds - time default wait before select fails
useEnv = 'portaluat'
env = {
  'fredmod'   :  'https://fredmod.eagle.org/portal/#/Login',
  'fredint'   :  'https://fredint.eagle.org/portal/#/Login',
  'portaluat' :  'https://portaluat.eagle.org/portal//#/Login'
}

# --------------------------------- #
# Settings - Change if you have to  #
# --------------------------------- #
if useBrowser == 'edge':
    # Add webdrivers as needed (edge / chrome / firefox)
    browser = webdriver.Edge('msedgedriver')
else:
    browser = webdriver.Chrome()
browser.get(env[useEnv])

if maxWindowOnLoad == True:
    browser.set_window_size(1440, 900)
    browser.maximize_window()

# time to try to find NEXT element before timeout
# should be used to you just need for next item to exist before you continue
def pause(time = defaultWaitTime):
    browser.implicitly_wait(time)
# force browser to pause before moving on
# should be used to you need to see what is happening
def fPause(time = defaultWaitTime):
    browser.implicitly_wait(time)
    cantGetItem = browser.find_elements_by_css_selector('.will-never-find-this-item')

# /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\ #
# ------------------------------------------------------------------ #
# ===================== Tests / Commands below ===================== #
# ------------------------------------------------------------------ #
# \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ #

print('RUNNING FILE')
#Login, go to home, logout
runTest = True

if runTest:
    # lOGIN
    Login(browser, pause, 'MTM', 'abc12345')
    print('SANITY PASS: LOGIN SUCCESSFULLY')
    fPause(2)
    
    # NAVIGATE TO HOME PAGE
    Nav(browser, By, pause, "Home")
    print('SANITY PASS: LANDED IN HOME PAGE SUCCESSFULLY')
    fPause(3)
    
    # REFRESH THE PAGE TO CLOSE THE SMART SCHEDULAR POP UP WINDOW
    browser.refresh()
    fPause(7)
 
    # NAVIGATING TO PLAN REVIEW PAGE
    Nav(browser, By, pause, "Plan Review")
    print('SANITY PASS: LANDED IN PLAN REVIEW PAGE SUCCESSFULLY')
    fPause(1)
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')

    
    # CLICKING ON CLIENT PROJECTS_CLIENT
    navLink = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div/div/div/label[1]')
    fPause(2)
    print('SANITY PASS:CLIENT PROJECTS PAGE OPENS UP SUCCESSFULLY')
    fPause(2)
    
    # Calculating Total Number of Vessels under client Projects in the Plan Review Page and clicking on the Total Filter
    values = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[1]/div/div/div[2]/div/a/h1')
    buttonValue = values.text
    pause()
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("CLICKING ON TOTAL NUMBER OF VESSELS FILTER UNDER ACTIVE PROJECTS UNDER CLIENT CARD")
    print("--------------")
    pause()
    
    # CLICKING ON DRAWINGS Not Submitted BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[2]/div/div/div[2]/div/a[1]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR DRAWINGS NOT SUBMITTED")
    print("--------------")
    fPause(2)
    
    # CLICKING ON DRAWINGS Customer Action BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[2]/div/div/div[2]/div/a[2]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR DRAWINGS Customer Action")
    print("--------------")
    fPause(2)
    
    # CLICKING ON COMMENTS Technical BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[3]/div/div/div[2]/div/a[1]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR COMMENTS Technical")
    print("--------------")
    fPause(2)
    
    # CLICKING ON COMMENTS Survey BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[3]/div/div/div[2]/div/a[2]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR COMMENTS Survey ")
    print("--------------")
    fPause(2)
    
    # CLICKING ON COMMENTS Customer Action Comments BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[3]/div/div/div[2]/div/a[3]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR COMMENTS Customer Action Comments")
    print("--------------")
    fPause(2)
    
    # Clicking on All Projects link
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[4]/div/div/div[2]/div/div[1]/a')
    button.click()
    print("SANITY PASS: CLICKING ON ALL PROJECTED OPENED UP A SEAPARATE WINDOW")
    fPause(5)
     
    # CLOSING THE NEW WINDOW OPENED
    browser.switch_to.window(window_name=browser.window_handles[-1])
    browser.close()
    browser.switch_to.window(window_name=browser.window_handles[0])
    fPause()
     
    # Clicking on Oversight Permission link
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[4]/div/div/div[2]/div/div[2]/a')
    button.click()
    print("SANITY PASS: CLICKING ON OVERSIGHT PERMISSION LINK OPENED UP A SEPARATE WINDOW")
    fPause(5)
     
    # CLOSING THE NEW WINDOW OPENED
    browser.switch_to.window(window_name=browser.window_handles[-1])
    browser.close()
    browser.switch_to.window(window_name=browser.window_handles[0])
    fPause()
  
    #NAVIGATING BACK TO PLAN REVIEW PAGE
    Nav(browser, By, pause, "Plan Review")
     
    # SEARCHING FOR A VESSEL BY ENTERING A NAME
    searchinput = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[2]/div/input')
    searchinput.send_keys("MTM")
    fPause(3)
    print('SANITY PASS:Search by Vessel name Successful')
     
    # CLEARING THE ENTERED VESSEL NAME
    Searchicon = browser.find_elements_by_xpath('//main/div/div[2]/div[3]/div[2]/div/button')
    Searchicon[0].click()
    fPause(2)
    print('SANITY PASS:Erase Vessel name Successful')
    fPause(1)
     
    # Clicking on one of the cards Agnes victory COMMENT REPORTS BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[3]/div[1]/div/div/div[4]/div[1]/div/button')
    button.click()
    print("SANITY PASS: CLICKING ON COMMENT REPORTS BUTTON OPENED UP A SEAPARATE WINDOW")
    fPause(5)
     
    # CLOSING THE NEW WINDOW OPENED
    browser.switch_to.window(window_name=browser.window_handles[-1])
    browser.close()
    browser.switch_to.window(window_name=browser.window_handles[0])
    fPause()
    print("SANITY PASS: CLOSED THE OPENED SEAPARATE WINDOW")
     
    #NAVIGATING BACK TO PLAN REVIEW PAGE
    Nav(browser, By, pause, "Plan Review")
     
    # Clicking on one of the cards Agnes victory DRAWINGS REPORTS BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[3]/div[1]/div/div/div[4]/div[2]/div/button')
    button.click()
    print("SANITY PASS: CLICKING ON DRAWINGS REPORTS BUTTON OPENED UP A SEAPARATE WINDOW")
    fPause(5)
    
    # CLOSING THE NEW WINDOW OPENED
    browser.switch_to.window(window_name=browser.window_handles[-1])
    browser.close()
    browser.switch_to.window(window_name=browser.window_handles[0])
    fPause()
    print("SANITY PASS: CLOSED THE OPENED SEAPARATE WINDOW")
   
    # NAVIGATING BACK TO PLAN REVIEW PAGE
    Nav(browser, By, pause, "Plan Review")
    print('nav')
    # CLICKING ON CLIENT PROJECTS_OVERSIGHT
    browser.find_element_by_tag_name('body').send_keys(Keys.CONTROL + Keys.HOME)
    fPause(2)
    navLink = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div/div/div/label[2]')
    navLink.click()
    fPause(2)
    print('SANITY PASS: OVERSIGHT PROJECTS PAGE OPENS UP SUCCESSFULLY')
    fPause(2)
    
    # Calculating Total Number of Vessels under Oversight Projects in the Plan Review Page and clicking on the Total Filter
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[1]/div/div/div[2]/div/a/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("CLICKING ON TOTAL NUMBER OF VESSELS FILTER UNDER ACTIVE PROJECTS UNDER OVERSIGHT CARD")
    print("--------------")
    pause()
    
    # CLICKING ON DRAWINGS Not Submitted BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[2]/div/div/div[2]/div/a[1]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: CORRECT FILTER COUNT VALIDATION SUCCESS FOR DRAWINGS NOT SUBMITTED")
    print("--------------")
    fPause(2)
    
    # CLICKING ON DRAWINGS Customer Action BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[2]/div/div/div[2]/div/a[2]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: CORRECT FILTER COUNT VALIDATION SUCCESS FOR DRAWINGS Customer Action ")
    print("--------------")
    fPause(2)
    
    # CLICKING ON COMMENTS Technical BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[2]/div/div/div[2]/div/a[2]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: CORRECT FILTER COUNT VALIDATION SUCCESS FOR COMMENTS Technical")
    print("--------------")
    fPause(2)
    
    # CLICKING ON COMMENTS Survey BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[3]/div/div/div[2]/div/a[2]/h1')
    button.click()
    value = button.text
    buttonValue = value.lstrip("0")
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".PlanApprovalCard")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: CORRECT FILTER COUNT VALIDATION SUCCESS FOR COMMENTS Survey")
    print("--------------")
    fPause(2)
    
    # Clicking on All Projects link
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[4]/div/div/div[2]/div/div[1]/a')
    button.click()
    print("SANITY PASS: CLICKING ON ALL PROJECTED OPENED UP A SEAPARATE WINDOW")
    fPause(5)
     
    # CLOSING THE NEW WINDOW OPENED
    browser.switch_to.window(window_name=browser.window_handles[-1])
    browser.close()
    browser.switch_to.window(window_name=browser.window_handles[0])
    fPause()
    print("SANITY PASS: CLOSED THE OPENED SEAPARATE WINDOW")
  
    # Clicking on Oversight Permission link
    button = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div[1]/div[4]/div/div/div[2]/div/div[2]/a')
    button.click()
    print("SANITY PASS: CLICKING ON OVERSIGHT PERMISSION LINK OPENED UP A SEPARATE WINDOW")
    fPause(5)
     
    # CLOSING THE NEW WINDOW OPENED
    browser.switch_to.window(window_name=browser.window_handles[-1])
    browser.close()
    browser.switch_to.window(window_name=browser.window_handles[0])
    fPause()
    print("SANITY PASS: CLOSED THE OPENED SEAPARATE WINDOW")
     
    #NAVIGATING BACK TO PLAN REVIEW PAGE
    Nav(browser, By, pause, "Plan Review")
    fPause(3)
  
    # LOGGING OUT OF CUSTOMER PORTAL
    Logout(browser, pause)
    print('SANITY PASS:Plan Review page Sanity Test Successful')