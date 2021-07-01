# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
import time
from selenium.webdriver.common.action_chains import ActionChains

# Our imports
from Login import Login, Logout
from Nav import Nav, navToSublink
from constants import constPaths # paths that should never change




    
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
#     Add webdrivers as needed (edge / chrome / firefox)
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


# /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\ #
# ------------------------------------------------------------------ #
# ===================== Tests / Commands below ===================== #
# ------------------------------------------------------------------ #
# \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ #

   
runTest = True
if runTest:
    # Login   
    Login(browser, pause, 'juchen', 'abc12345')
    print('LOGIN SUCCESSFUL')
    fPause(1)
    
    # Navigate to Home Page     
    Nav(browser, By, pause, "Home")
    fPause()
    print('SANITY PASS: LANDED ON HOME PAGE')
    
    # Refresh the page to close the smart schedular pop up
    browser.refresh()

    # Navigate to FLEET OVERVIEW PAGE  
    Nav(browser, By, pause, "Fleet Overview")
    fPause()
    print('SANITY PASS: LANDED ON FLEET OVERVIEW PAGE')
    
    #CLOSING THE FLEET VIEW ICON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[1]')
    button.click()
    print('SANITY PASS: CLOSED THE FLEET VIEW ICON')
    
    #SELECTING CARD FROM THE LIST
    cardList = browser.find_elements_by_css_selector('.vessel-cards-list .row .ibox')
    cardList[1].click() #click 2nd card
    print(len(cardList))
    pause()
    print('SANITY PASS: SELECTED CARD CAPE MARS')
    pause()
    
    # NAVIGATE TO VESSEL ALERST ARCHIVE PAGE
    navToSublink(browser, pause, By, 'Vessel','Alerts Archive')
    fPause()
    print('SANITY PASS: LANDED ON ALERTS ARCHIVE PAGE')
    
    #TAKING A SCREEN CAPTURE
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000))
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
 
    # CLICKING ON THE FILTER BY MONTHS BUTTON
    button = browser.find_elements_by_xpath("//main/div/div[2]/div/div[3]/div/div[2]/div[1]/div/div/button")
    button[0].click()
    button = browser.find_element_by_xpath("//main/div/div[2]/div/div[3]/div/div[2]/div[1]/div/div/div/button[2]")
    button.click()
    fPause()
    print ("SANITY PASSED: CLICKED ON THE MONTHS BUTTON AND SELECTED 6 MONTHS OPTION SUCCESSFULLY")
    
    # clicking on the Notification
    button = browser.find_elements_by_xpath('//main/div/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div/div[1]/div/div[1]/i')
    button.click()
    fPause(2)
    print ("SANITY PASSED: NAVIGATED TO THE SELECTED NOTIFICATION SUCCESSFULLY")
    
    # TO SCROLL UP THE PAGE
    actions = ActionChains(browser)
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[1]/div/button')
    actions = ActionChains(browser)
    actions.move_to_element(button).perform() 
    
    #NAVIGATED BACK TO ALERTS ARCHIVE PAGE
    button = browser.find_element_by_xpath("//main/div/div[2]/div/div[2]/div[1]/div/button")
    button.click()
    print ("SANITY PASSED: NAVIGATED BACK TO VESSEL ALERTS PAGE SUCCESSFULLY")
    fPause()
    
    # LOGGING OUT OF THE PAGE
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')
  
    
    
    
    
    
  

  
    
    
    
    
    
  

