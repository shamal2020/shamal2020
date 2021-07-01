# Library imports
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
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

# Created open link in background function
# Pass it the EXTERNAL LINK
# It will
    # switch to that tab
    # check for pop - ups and close them
    # take a screenshot
    # close that tab
    # switch back to main tab

# TO USE CALL: openLinkInBg(name-of-link) -> openLinkInBg(Widget)

def screenShotAndCloseTab():
    fPause(15)
    print("Pause over")
    while (len(browser.window_handles) > 1):
        print("Closing tabs")
        browser.switch_to.window(window_name=browser.window_handles[-1])
        pause()
        try:
            alert_obj = browser.switch_to.alert
            alert_obj.accept()
        except:
            print("continue")
        ms = int(round(time.time() * 1000))
        browser.save_screenshot("screenshots/screenshot_" + str(len(browser.window_handles)) + "-" + str(ms) + ".png")
        browser.close()
        browser.switch_to.window(window_name=browser.window_handles[0])

def openLinkInBg(itemToClick):
    action = ActionChains(browser)
    action.key_down(Keys.CONTROL).perform()
    itemToClick.click()
    action.key_up(Keys.CONTROL).perform()
    screenShotAndCloseTab()

print('RUNNING FILE')
#Login, go to home, logout
runTest = True
if runTest:
    #Logging In the Page
    Login(browser, pause, 'MTM', 'abc12345')
    
    # Navigating to Home page
    Nav(browser, By, pause, "Home")
    print('SANITY PASS:Login Successful')
    fPause(2)
    
    # Refresh the page to close the smart schedular pop up
    browser.refresh()
    fPause(7)
    
    #LOCATING AND CLICKING ON VIEW ORDERS BUTTON UNDER ACTIVE ORDERS ON HOMEPAGE
    pause()
    button = browser.find_elements_by_css_selector('.ActiveOrders .ibox button')
    button[0].click()
    print('SANITY PASS:Clicking on View Orders button, lands to Vessel Orders page Successful')
    fPause(3)
    
    #Navigating back to Home page
    Nav(browser, By, pause, "Home")
    fPause(5)
    print('SANITY PASS: landing on Home page Successful')


    #NAVIGATING TO WEB CALC MACHINERY PAGE
    pause()
    Widget = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div/div/div[2]/div[1]/a/div/div[1]/h3')
    openLinkInBg(Widget)
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    #Navigating back to Home page
    Nav(browser, By, pause, "Home")
    fPause(2)
    print('SANITY PASS: landing on Home page Successful')

    #NAVIGATING TO WEB CALC STRUCTURES PAGE
    Widget = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div/div/div[2]/div[2]/a/div/div[1]/h3')
    openLinkInBg(Widget)
    fPause(2)
    print('SANITY PASS:Web Calc Structures page launched Successfully') 


    #NAVIGATING TO RULES MANAGER PAGE
    fPause(2)
    Widget = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div/div/div[2]/div[3]/a/div/div[1]/h3')
    fPause(2)
    openLinkInBg(Widget)
    print('SANITY PASS:Rules Manger page launched Successfully') 
    
    #Navigating back to Home page 
    Nav(browser, By, pause, "Home")
    fPause(2)
    print('SANITY PASS: landing on Home page Successful')


    #NAVIGATING TO RULES DOWNLOAD PAGE
    Widget = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div/div/div[2]/div[4]/a/div/div[1]/h3')
    openLinkInBg(Widget)
    print('SANITY PASS:Rules Download page launched Successfully')
    
    #TAKING A SCREEN CAPTURE 
    print('SANITY PASS:Taking SS')
    
    #Navigating back to Home page
    Nav(browser, By, pause, "Home")
    fPause(2)
    print('SANITY PASS: landing on Home page Successful')

    #NAVIGATING TO RULES ARCHIVE PAGE
    Widget = browser.find_element_by_xpath('//main/div/div[2]/div[3]/div/div/div[2]/div[5]/a/div/div[1]/h3')
    openLinkInBg(Widget)
    print('SANITY PASS:Rules Archive page launched Successfully')
    #TAKING A SCREEN CAPTURE 
    print('SANITY PASS:Taking SS')
    
    #Navigating back to Home page
    Nav(browser, By, pause, "Home")
    fPause(2)
    print('SANITY PASS: landing on Home page Successful')
    
    #logging out of the page
    Logout(browser, pause)
    print('SANITY SIT PASS:Logout Successful')